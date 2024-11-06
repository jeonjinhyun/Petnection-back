package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.app.presentation.dto.request.GalleryImageRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GalleryImageMapper {
    GalleryImage toGalleryImage(GalleryImageRequestDto dto);
}
