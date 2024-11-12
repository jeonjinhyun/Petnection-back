package com.jjh.mtvs.application.service.myroom;

import com.jjh.mtvs.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GalleryService {
    Boolean deleteGallery(Long id);
    GalleryResponseDto getGallery(Long id);
    Boolean createGallery(GalleryRequestDTO dto);
    Boolean updateGalleryImages(GalleryRequestDTO dto);
}