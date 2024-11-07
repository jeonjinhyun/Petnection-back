package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.user.entity.Pet;
import com.jjh.mtvs.app.presentation.dto.request.user.PetCreateRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.PetResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    @Mapping(target = "user", ignore = true)
    Pet toPet(PetCreateRequestDTO dto);

    PetResponseDto toPetResponseDto(Pet pet);
}
