package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.GalleryImageMapper;
import com.jjh.mtvs.app.application.mapper.GalleryMapper;
import com.jjh.mtvs.app.application.service.GalleryService;
import com.jjh.mtvs.app.application.service.ImageAnalysisService;
import com.jjh.mtvs.app.application.service.UserQueryService;
import com.jjh.mtvs.app.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.app.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.domain.repository.GalleryImageRepository;
import com.jjh.mtvs.app.domain.repository.GalleryRepository;
import com.jjh.mtvs.app.domain.repository.UserRepository;
import com.jjh.mtvs.app.presentation.dto.request.myroom.GalleryImageRequestDTO;
import com.jjh.mtvs.app.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.GalleryResponseDto;
import com.jjh.mtvs.common.util.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final GalleryMapper galleryMapper;
    private final FileUploadService fileService;
    private final ImageAnalysisService imageAnalysisService;
    private final GalleryImageRepository galleryImageRepository;
    private final GalleryImageMapper galleryImageMapper;
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
    public Boolean createGallery(GalleryRequestDTO dto) {
        try {
            // 기본 갤러리 정보 매핑
            Gallery gallery = galleryMapper.toGallery(dto);
            User user = userQueryService.getUser(dto.getUserId());
            // 이미지 파일들이 있다면 처리
            if (dto.getGalleryImageRequestDTOS() != null && !dto.getGalleryImageRequestDTOS().isEmpty()) {
                for (GalleryImageRequestDTO imageDto : dto.getGalleryImageRequestDTOS()) {
                    if (imageDto.getImgFile() != null) {
                        // 파일 업로드 및 URL 받기
                        String imageUrl = fileService.uploadFile(imageDto.getImgFile());
                        // AI 분석 수행
                        String analysisResult = imageAnalysisService.analyzeImage(imageDto.getImgFile());

                        // GalleryImage 생성 및 설정
                        GalleryImage galleryImage = new GalleryImage();
                        galleryImage.setImgUrl(imageUrl);
                        galleryImage.setAiAnalyze(analysisResult);

                        // Gallery에 이미지 추가 (양방향 관계 설정)
                        gallery.addImage(galleryImage);
                    }
                }
            }
            user.setGallery(gallery);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public GalleryResponseDto getGallery(Long id) {
        Optional<Gallery> galleryOptional = galleryRepository.findById(id);
        return galleryOptional.map(galleryMapper::toGalleryResponseDto).orElse(null);
    }



    @Override
    @Transactional
    public Boolean updateGalleryImages(GalleryRequestDTO galleryRequestDto) {
        try {
            Gallery gallery = galleryRepository.findById(galleryRequestDto.getUserId())
                    .orElseThrow(()->new RuntimeException("갤러리를 찾는데 실패했습니다."));

            List<GalleryImageRequestDTO> galleryImageRequestDTOS = galleryRequestDto.getGalleryImageRequestDTOS();

            for(GalleryImageRequestDTO dto : galleryImageRequestDTOS){
                if(dto.getId()!=null){
                    gallery.removeImageById(dto.getId());
                    galleryImageRepository.deleteById(dto.getId());
                }else{
                    GalleryImage image = galleryImageMapper.toGalleryImage(dto);
                    String analysisResult = imageAnalysisService.analyzeImage(dto.getImgFile());
                    image.setAiAnalyze(analysisResult);
                    image.setImgUrl(fileService.uploadFile(dto.getImgFile()));
                    gallery.addImage(image);
                }
            }
            galleryRepository.save(gallery);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}