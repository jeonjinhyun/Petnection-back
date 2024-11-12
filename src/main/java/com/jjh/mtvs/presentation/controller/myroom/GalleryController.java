package com.jjh.mtvs.presentation.controller.myroom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjh.mtvs.application.mapper.ObjectMapperImpl;
import com.jjh.mtvs.application.service.myroom.GalleryService;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryRequestDTO;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gallery")
@RequiredArgsConstructor
@Tag(name = "Gallery", description = "갤러리 관련 API")
public class GalleryController {

    private final GalleryService galleryService;
    private final ObjectMapper objectMapper;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> createGallery(
            @ModelAttribute GalleryRequestDTO galleryRequestDTO
    ) {
        try {
            return ResponseEntity.ok(galleryService.createGallery(galleryRequestDTO));
        } catch (Exception e) {
            throw new RuntimeException("갤러리 생성 중 오류가 발생했습니다.", e);
        }
    }

    @Operation(summary = "갤러리 수정", description = "기존 갤러리의 이미지를 수정합니다.")
    @PutMapping(value = "/images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> updateGalleryImages(
            @ModelAttribute GalleryRequestDTO galleryRequestDTO
    ) {
        try {
            return ResponseEntity.ok(galleryService.updateGalleryImages(galleryRequestDTO));
        } catch (Exception e) {
            throw new RuntimeException("갤러리 이미지 수정 중 오류가 발생했습니다.", e);
        }
    }
    @Operation(summary = "갤러리 조회", description = "갤러리 정보를 조회합니다.")
    @GetMapping("/{galleryId}")
    public ResponseEntity<GalleryResponseDto> getGallery(@PathVariable Long galleryId) {
//        GalleryResponseDto galleryResponseDto =galleryService.getGallery(galleryId);
        try {
//            String jsonResponse = objectMapper.writeValueAsString(galleryResponseDto);
//            return ResponseEntity.ok(jsonResponse);
            return ResponseEntity.ok(galleryService.getGallery(galleryId));
//        } catch (JsonProcessingException e) {
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "갤러리 삭제", description = "갤러리를 삭제합니다.")
    @DeleteMapping("/{galleryId}")
    public ResponseEntity<Boolean> deleteGallery(@PathVariable Long galleryId) {
        return ResponseEntity.ok(galleryService.deleteGallery(galleryId));
    }
}