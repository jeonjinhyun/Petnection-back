package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.GalleryResponseDto;

public interface GalleryService {
    Boolean deleteGallery(Long id);
    GalleryResponseDto getGallery(Long id);
    Boolean createGallery(GalleryRequestDTO dto);
    Boolean updateGalleryImages(GalleryRequestDTO dto);
}
