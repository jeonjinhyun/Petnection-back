package com.jjh.mtvs.application.serviceimpl.myroom;

import com.jjh.mtvs.application.mapper.GalleryMapper;
import com.jjh.mtvs.application.service.myroom.GalleryService;
import com.jjh.mtvs.application.service.myroom.ImageAnalysisService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.myroom.GalleryRepository;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryImageRequestDTO;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryResponseDto;
import com.jjh.mtvs.common.util.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;
    private final FileUploadService fileService;
    private final ImageAnalysisService imageAnalysisService;
    private final UserQueryService userQueryService;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Boolean deleteGallery(Long id) {
        try {
            galleryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public GalleryResponseDto getGallery(Long id) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("갤러리를 찾는데 실패했습니다."));
        return galleryMapper.toGalleryResponseDto(gallery);
    }
    @Override
    @Transactional
    public Boolean createGallery(GalleryRequestDTO dto) {
        try {
            User user = userQueryService.getUser(dto.getUserId());
            Gallery existingGallery = user.getGallery();
            Gallery gallery;

            if (existingGallery != null) {
                galleryMapper.updateGalleryFromDto(dto, existingGallery);
                gallery = existingGallery;
            } else {
                gallery = galleryMapper.toGallery(dto);
                user.setGallery(gallery);
            }

            // 이미지 처리를 독립적으로 수행
            if (dto.getGalleryImageRequestDTOs() != null) {
                for (GalleryImageRequestDTO imageDto : dto.getGalleryImageRequestDTOs()) {
                    try {
                        processAndAddGalleryImage(imageDto, gallery);
                    } catch (Exception e) {
                        log.error("Failed to process image: {}", imageDto.getImgFile().getOriginalFilename(), e);
                        // 개별 이미지 실패는 무시하고 계속 진행
                    }
                }
            }

            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Failed to create gallery", e);
            return false;
        }
    }

    private void processAndAddGalleryImage(GalleryImageRequestDTO imageDto, Gallery gallery) {
        if (imageDto.getImgFile() != null) {
            try {
                String imageUrl = fileService.uploadFile(imageDto.getImgFile());
                String analysisResult;

                try {
                    analysisResult = imageAnalysisService.analyzeImage(imageDto.getImgFile(), gallery.getId());
                } catch (Exception e) {
                    log.warn("Image analysis failed, using default message", e);
                    analysisResult = "이미지 분석에 실패했습니다.";
                }

                GalleryImage galleryImage = new GalleryImage();
                galleryImage.setImgUrl(imageUrl);
                galleryImage.setAiAnalysis(analysisResult);
                gallery.addImage(galleryImage);
            } catch (Exception e) {
                throw new RuntimeException("이미지 처리 중 오류가 발생했습니다: " + e.getMessage(), e);
            }
        }
    }

    @Override
    @Transactional
    public Boolean updateGalleryImages(GalleryRequestDTO galleryRequestDto) {
        try {
            Gallery gallery = galleryRepository.findById(galleryRequestDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("갤러리를 찾는데 실패했습니다."));

            if (galleryRequestDto.getGalleryImageRequestDTOs() != null) {
                for (GalleryImageRequestDTO dto : galleryRequestDto.getGalleryImageRequestDTOs()) {
                    try {
                        if (dto.getId() != null) {
                            gallery.removeImageById(dto.getId());
                        } else {
                            processAndAddGalleryImage(dto, gallery);
                        }
                    } catch (Exception e) {
                        log.error("Failed to process image operation", e);
                        // 개별 이미지 처리 실패는 무시
                    }
                }
            }

            return true;
        } catch (Exception e) {
            log.error("Failed to update gallery images", e);
            return false;
        }
    }
    private void processGalleryImages(Gallery gallery, List<GalleryImageRequestDTO> imageDtos) {
        for (GalleryImageRequestDTO imageDto : imageDtos) {
            processAndAddGalleryImage(imageDto, gallery);
        }
    }
}
