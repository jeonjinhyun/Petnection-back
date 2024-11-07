package com.jjh.mtvs.app.presentation.controller.user;

import com.jjh.mtvs.app.application.service.PetAiTextureService;
import com.jjh.mtvs.app.presentation.dto.request.user.PetTextureCreateRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/pet")
@Tag(name = "Pet", description = "반려동물 관련 API")
@RequiredArgsConstructor
public class PetController {

    private final PetAiTextureService petAiTextureService;

    @Operation(summary = "반려동물 모델 생성", description = "이미지를 기반으로 반려동물 모델을 생성합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CompletableFuture<ResponseEntity<String>> createPetModel(
            @ModelAttribute PetTextureCreateRequestDTO dto) {
        return petAiTextureService.createPetModel(dto)
                .thenApply(ResponseEntity::ok);
    }
}