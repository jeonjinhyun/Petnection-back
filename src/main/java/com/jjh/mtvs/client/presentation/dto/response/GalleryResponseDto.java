package com.jjh.mtvs.client.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
@Schema(description = "갤러리 응답 DTO")
public class GalleryResponseDto {
    @Schema(description = "갤러리 ID", example = "1")
    private Long id;

    @Schema(description = "갤러리 이름", example = "나의 추억")
    private String name;

    @Schema(description = "갤러리 이미지 목록")
    private List<GalleryImageResponseDto> galleryImageResponseDtos;
}
