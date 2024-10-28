package com.jjh.mtvs.pet.presentation.controller;

import com.jjh.mtvs.pet.application.service.PetAiTextureService;
import com.jjh.mtvs.pet.presentation.dto.CreatePetReqDto;
import com.jjh.mtvs.pet.presentation.dto.CreatePetResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/pet")
public class PetController {
    private final PetAiTextureService petAiTextureService;

    public PetController(PetAiTextureService petAiTextureService) {
        this.petAiTextureService = petAiTextureService;
    }

    @PostMapping("/texture")
    public ResponseEntity<CreatePetResDto> createPet(@RequestParam CreatePetReqDto createPetReqDto) throws Exception {
        CreatePetResDto createPetResDto =petAiTextureService.createPetTexture(createPetReqDto);
        return ResponseEntity.ok(createPetResDto);
    }
}
