package com.jjh.mtvs.pet.presentation.dto;

import com.jjh.mtvs.pet.domain.aggregate.enums.PetType;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreatePetReqDto {
    private Long userId;
    private MultipartFile petImg;
    private PetType petType;
}
