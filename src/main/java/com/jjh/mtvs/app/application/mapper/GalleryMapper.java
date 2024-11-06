package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.app.presentation.dto.request.GalleryRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.GalleryResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GalleryMapper {
    GalleryResponseDto toGalleryResponseDto(Gallery gallery);

    Gallery toGallery(GalleryRequestDto dto);
}
