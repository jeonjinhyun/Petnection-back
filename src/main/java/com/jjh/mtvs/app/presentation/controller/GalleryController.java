package com.jjh.mtvs.app.presentation.controller;

import com.jjh.mtvs.app.application.service.GalleryService;
import com.jjh.mtvs.app.presentation.dto.request.GalleryImageRequestDto;
import com.jjh.mtvs.app.presentation.dto.request.GalleryRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.GalleryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/gallery")
@Tag(name = "Gallery", description = "갤러리 관련 API")
@RequiredArgsConstructor
public class GalleryController {
    private final GalleryService galleryService;

    @Operation(summary = "갤러리 삭제", description = "특정 갤러리를 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGallery(
            @Parameter(description = "갤러리 ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(galleryService.deleteGallery(id));
    }

    @Operation(summary = "갤러리 조회", description = "특정 갤러리의 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<GalleryResponseDto> getGallery(
            @Parameter(description = "갤러리 ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(galleryService.getGallery(id));
    }

    @Operation(summary = "갤러리 생성", description = "새로운 갤러리를 생성합니다.")
    @PostMapping
    public ResponseEntity<Boolean> createGallery(
            @Parameter(description = "갤러리 정보", required = true)
            @ModelAttribute GalleryRequestDto dto) {
        return ResponseEntity.ok(galleryService.createGallery(dto));
    }

    @Operation(summary = "갤러리 이미지 업데이트", description = "갤러리의 이미지들을 업데이트하고 AI 분석을 수행합니다.")
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> updateGalleryImages(
            @ModelAttribute GalleryRequestDto dto) {
        return ResponseEntity.ok(galleryService.updateGalleryImages(dto));
    }
}
