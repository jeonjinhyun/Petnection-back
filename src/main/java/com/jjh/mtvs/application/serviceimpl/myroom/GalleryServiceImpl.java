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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;
    private final FileUploadService fileUploadService;
    private final ImageAnalysisService imageAnalysisService;
    private final UserRepository userRepository;
    private final UserQueryService userQueryService;

    @Override
    @Transactional
    public Boolean deleteGallery(Long id) {
        try {
            galleryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Gallery deletion failed for id: {}", id, e);
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GalleryResponseDto getGallery(Long id) {
        Gallery gallery = galleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("갤러리를 찾을 수 없습니다. ID: " + id));
        return galleryMapper.toGalleryResponseDto(gallery);
    }

    @Override
    @Transactional
    public Boolean createGallery(GalleryRequestDTO dto) {
        try {
            // 기본 갤러리 정보 매핑
            Gallery gallery = galleryMapper.toGallery(dto);
            User user = userQueryService.getUser(dto.getUserId());
            gallery.setId(user.getId());
            // 이미지 처리
            if (dto.getGalleryImages() != null && !dto.getGalleryImages().isEmpty()) {
                for (GalleryImageRequestDTO imageDto : dto.getGalleryImages()) {
                    if (imageDto.getImgFile() != null && !imageDto.getImgFile().isEmpty()) {
                        processAndAddGalleryImage(imageDto, gallery);
                    }
                }
            }

            user.setGallery(gallery);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            log.error("Gallery creation failed for user id: {}", dto.getUserId(), e);
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean updateGalleryImages(GalleryRequestDTO dto) {
        try {
            Gallery gallery = galleryRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("갤러리를 찾을 수 없습니다. ID: " + dto.getUserId()));

            if (dto.getName() != null) {
                gallery.setName(dto.getName());
            }

            // 이미지 업데이트 처리
            if (dto.getGalleryImages() != null) {
                for (GalleryImageRequestDTO imageDto : dto.getGalleryImages()) {
                    // ID가 있으면 기존 이미지 삭제
                    if (imageDto.getId() != null) {
                        gallery.removeImageById(imageDto.getId());
                    }
                    // 새 이미지 파일이 있으면 추가
                    if (imageDto.getImgFile() != null && !imageDto.getImgFile().isEmpty()) {
                        processAndAddGalleryImage(imageDto, gallery);
                    }
                }
            }

            galleryRepository.save(gallery);
            return true;
        } catch (Exception e) {
            log.error("Gallery update failed for user id: {}", dto.getUserId(), e);
            return false;
        }
    }

    private void processAndAddGalleryImage(GalleryImageRequestDTO imageDto, Gallery gallery) throws Exception {
        String imageUrl = fileUploadService.uploadFile(imageDto.getImgFile());
        String analysisResult = "";

        try {
            analysisResult = imageAnalysisService.analyzeImage(imageDto.getImgFile(),gallery.getId());
        } catch (Exception e) {
            log.warn("Image analysis failed for gallery: {}", gallery.getId(), e);
            analysisResult = "이미지 분석에 실패했습니다.";
        }

        GalleryImage galleryImage = new GalleryImage();
        galleryImage.setImgUrl(imageUrl);
        galleryImage.setAiAnalysis(analysisResult);
        gallery.addImage(galleryImage);
    }
}