package com.jjh.mtvs.application.service.user;

import com.jjh.mtvs.presentation.dto.request.user.PetTextureCreateRequestDTO;
import com.jjh.mtvs.presentation.dto.response.user.FurAnalysisResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

public interface PetAiTextureService {
    CompletableFuture<String> createPetModel(PetTextureCreateRequestDTO petTextureCreateRequestDTO);

    FurAnalysisResponseDTO analyzeFurColor(MultipartFile image);
}
