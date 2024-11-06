package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.request.PetCreateDto;

import java.util.concurrent.CompletableFuture;

public interface PetAiTextureService {
    CompletableFuture<String> createPetModel(PetCreateDto petCreateDto);
}
