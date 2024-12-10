package com.jjh.mtvs.presentation.dto.response.community;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "반려동물 이미지 응답 DTO")
public class GoodsResponseDto {
    @Schema(description = "이미지 ID")
    private Long id;

    @Schema(description = "원본 이미지 URL")
    private String originalImageUrl;

    @Schema(description = "생성된 이미지 URL")
    private String generatedImageUrl;
}
