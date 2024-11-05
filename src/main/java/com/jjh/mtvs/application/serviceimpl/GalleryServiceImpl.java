package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.GalleryService;
import com.jjh.mtvs.presentation.dto.request.GalleryImageRequestDto;
import com.jjh.mtvs.presentation.dto.request.GalleryRequestDto;
import com.jjh.mtvs.presentation.dto.response.GalleryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GalleryServiceImpl implements GalleryService {
    @Override
    public Boolean deleteGallery(Long id) {
        return null;
    }

    @Override
    public GalleryResponseDto getGallery(Long id) {
        return null;
    }

    @Override
    public Boolean createGallery(GalleryRequestDto dto) {
        return null;
    }

    @Override
    public Boolean updateGalleryImages(List<GalleryImageRequestDto> dtos) {
        return null;
    }
}
