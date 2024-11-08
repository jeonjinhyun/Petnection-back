package com.jjh.mtvs.application.service.user;

import com.jjh.mtvs.presentation.dto.request.user.PetTextureCreateRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface PetAiTextureService {
    CompletableFuture<String> createPetModel(PetTextureCreateRequestDTO petTextureCreateRequestDTO);
}
