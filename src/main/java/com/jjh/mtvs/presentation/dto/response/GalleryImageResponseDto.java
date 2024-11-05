package com.jjh.mtvs.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "갤러리 이미지 응답 DTO")
public class GalleryImageResponseDto {
    @Schema(description = "이미지 ID", example = "1")
    private Long id;

    @Schema(description = "이미지 URL", example = "https://example.com/gallery/image.jpg")
    private String imgUrl;

    @Schema(description = "AI 분석 결과", example = "이 사진에는 강아지와 사람이 있습니다.")
    private String aiAnalysis;
}