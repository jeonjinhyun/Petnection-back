package com.jjh.mtvs.pet.presentation.dto;

import com.jjh.mtvs.pet.domain.aggregate.entity.Embedded.PetId;
import lombok.Data;

@Data
public class CreatePetResDto {
    private PetId petId;
    private String textureUrl;

    public CreatePetResDto(PetId petId, String textureUrl) {
        this.petId = petId;
        this.textureUrl = textureUrl;
    }
}