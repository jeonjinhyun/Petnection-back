package com.jjh.mtvs.app.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
@Schema(description = "갤러리 요청 DTO")
public class GalleryRequestDto {
    @Schema(description = "사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "갤러리 이름", example = "나의 추억")
    private String name;

    @Schema(description = "갤러리 이미지 목록")
    private List<GalleryImageRequestDto> galleryImageRequestDtos;
}