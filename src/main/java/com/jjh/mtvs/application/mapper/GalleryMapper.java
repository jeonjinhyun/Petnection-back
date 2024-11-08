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

    @Mapping(target = "images",source = "galleryImageRequestDTOs")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "myRoom", ignore = true)
    Gallery toGallery(GalleryRequestDTO dto);

    // 기존 갤러리 업데이트를 위한 매핑 메서드
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "myRoom", ignore = true)
    @Mapping(target = "images", ignore = true)  // 이미지는 별도 처리
    void updateGalleryFromDto(GalleryRequestDTO dto, @MappingTarget Gallery gallery);


    @AfterMapping
    default void setGalleryReference(@MappingTarget Gallery gallery, GalleryRequestDTO dto) {
        if(dto.getGalleryImageRequestDTOs()!=null){
            dto.getGalleryImageRequestDTOs().stream()
                    .map(this::toGalleryImage)
                    .forEach(gallery::addImage);
        }
    }
    GalleryImage toGalleryImage(GalleryImageRequestDTO imageRequestDTO);
}
