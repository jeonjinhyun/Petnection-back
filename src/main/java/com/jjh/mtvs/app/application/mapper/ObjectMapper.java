package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.object.entity.Object;
import com.jjh.mtvs.app.presentation.dto.common.ObjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    Object toObject(ObjectDto dto);

    ObjectDto toObjectDto(Object object);
}
