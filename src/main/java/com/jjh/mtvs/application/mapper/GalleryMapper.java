package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryImageRequestDTO;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryImageResponseDto;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = GalleryImageMapper.class)
public interface GalleryMapper {

    @Mapping(target = "galleryImageResponseDtos",source = "images")
    GalleryResponseDto toGalleryResponseDto(Gallery gallery);

    Gallery toGallery(GalleryRequestDTO dto);
}