package com.jjh.mtvs.presentation.controller;

import com.jjh.mtvs.application.service.PetAiTextureService;
import com.jjh.mtvs.application.service.PetManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet")
@Tag(name = "Pet", description = "반려동물 관련 API")
@RequiredArgsConstructor
public class PetController {

    private final PetManagementService petManagementService;
    private final PetAiTextureService petAiTextureService;

    @Operation(summary = "반려동물 모델 생성", description = "이미지를 기반으로 반려동물 모델을 생성합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createPetModel(
            @ModelAttribute("formData") MultipartFile formData) {
        String url = petAiTextureService.createPetModel(formData);
        return ResponseEntity.ok(url);
    }

    @Operation(summary = "기본 반려동물 목록 조회", description = "기본 제공되는 반려동물 모델 목록을 조회합니다.")
    @GetMapping("/defaults")
    public ResponseEntity<List<String>> getDefaultPets(){
        List<String> defaultPetUrls = petManagementService.getDefaultPets();
        return ResponseEntity.ok(defaultPetUrls);
    }
}