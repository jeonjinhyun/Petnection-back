package com.jjh.mtvs.pet.application.service;

import com.jjh.mtvs.pet.domain.aggregate.entity.Embedded.PetId;
import com.jjh.mtvs.pet.domain.aggregate.entity.Pet;
import com.jjh.mtvs.pet.domain.infraservice.ExternalAiService;
import com.jjh.mtvs.pet.domain.infraservice.ExternalFileService;
import com.jjh.mtvs.pet.domain.repository.PetRepository;
import com.jjh.mtvs.pet.presentation.dto.AITextureResDto;
import com.jjh.mtvs.pet.presentation.dto.CreatePetReqDto;
import com.jjh.mtvs.pet.presentation.dto.CreatePetResDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PetAiTextureService {
    private final PetRepository petRepository;
    private final ExternalFileService externalFileService;
    private final ExternalAiService externalAiService;

    public PetAiTextureService(
            PetRepository petRepository,
            ExternalFileService externalFileService,
            ExternalAiService externalAiService) {
        this.petRepository = petRepository;
        this.externalFileService = externalFileService;
        this.externalAiService = externalAiService;
    }

    @Transactional
    public CreatePetResDto createPetTexture(CreatePetReqDto createPetReqDto) throws Exception {
        // 1. AI 서버에 이미지 전송 및 텍스처 수신
        AITextureResDto aiTextureResDto = externalAiService.getTexture(createPetReqDto.getPetImg());

        // 2. ExternalFileService를 통해 텍스처 업로드
        String textureUrl = externalFileService.uploadFile(aiTextureResDto.getTextureFile());

        // 3. Pet 엔티티 생성
        PetId petId = new PetId(aiTextureResDto.petModelId, createPetReqDto.getPetType());
        Pet pet = Pet.builder()
                .id(petId)
                .userId(createPetReqDto.getUserId())
                .textureUrl(textureUrl)
                .build();

        // 4. Pet 저장
        petRepository.save(pet);

        // 5. 응답 DTO 생성 및 반환
        return new CreatePetResDto(petId, textureUrl);
    }
}