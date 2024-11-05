package com.jjh.mtvs.test.controller;

import com.jjh.mtvs.test.dto.EmotionRequestDTO;
import com.jjh.mtvs.test.dto.EmotionResponseDTO;
import com.jjh.mtvs.test.dto.TextureRequestDTO;
import com.jjh.mtvs.test.dto.TextureResponseDTO;
import com.jjh.mtvs.test.service.AIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class AIServiceController {
    private final AIService aiService;

    public AIServiceController(AIService aiService) {
        this.aiService = aiService;
    }


    @PostMapping(value = "/analyze-pet-emotion", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity<?>> analyzePetEmotion(
            @RequestParam("image") MultipartFile image,
            @RequestParam("userId") long userId) {
        EmotionRequestDTO dto = new EmotionRequestDTO(image, userId);
        System.out.println("요청옴");
        return aiService.sendEmotion(dto)
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping(value = "/create-texture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.IMAGE_PNG_VALUE)
    public CompletableFuture<ResponseEntity<Resource>> createTexture(
            @RequestParam("image") MultipartFile image,
            @RequestParam("modelNumber") Integer petMeshNumber,
            @RequestParam("userId") long userId) {
        TextureRequestDTO dto = new TextureRequestDTO(image, petMeshNumber, userId);
        System.out.println("요청옴");
        return aiService.sendTexture(dto);
    }
}