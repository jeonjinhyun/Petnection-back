package com.jjh.mtvs.client.application.mapper;

import com.jjh.mtvs.client.domain.model.user.entity.Pet;
import com.jjh.mtvs.client.presentation.dto.request.PetRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "user", ignore = true)
    Pet toPet(PetRequestDto dto);
}
