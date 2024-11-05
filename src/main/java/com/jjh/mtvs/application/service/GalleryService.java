package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.request.GalleryImageRequestDto;
import com.jjh.mtvs.presentation.dto.request.GalleryRequestDto;
import com.jjh.mtvs.presentation.dto.response.GalleryResponseDto;

import java.util.List;

public interface GalleryService {
    Boolean deleteGallery(Long id);
    GalleryResponseDto getGallery(Long id);
    Boolean createGallery(GalleryRequestDto dto);
    Boolean updateGalleryImages(List<GalleryImageRequestDto> dtos);
}
