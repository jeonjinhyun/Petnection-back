package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.user.entity.Pet;
import com.jjh.mtvs.presentation.dto.request.PetRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "user", ignore = true)
    Pet toPet(PetRequestDto dto);
}
