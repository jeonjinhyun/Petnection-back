package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    Object toObject(ObjectDto dto);
    ObjectDto toObjectDto(Object object);
    List<Object> toObjects(List<ObjectDto> dtos);
    List<ObjectDto> toObjectDtos(List<Object> objects);
}