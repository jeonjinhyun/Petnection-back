package com.jjh.mtvs.client.application.service;

import com.jjh.mtvs.client.presentation.dto.request.GalleryImageRequestDto;
import com.jjh.mtvs.client.presentation.dto.request.GalleryRequestDto;
import com.jjh.mtvs.client.presentation.dto.response.GalleryResponseDto;

import java.util.List;

public interface GalleryService {
    Boolean deleteGallery(Long id);
    GalleryResponseDto getGallery(Long id);
    Boolean createGallery(GalleryRequestDto dto);
    Boolean updateGalleryImages(List<GalleryImageRequestDto> dtos);
}
