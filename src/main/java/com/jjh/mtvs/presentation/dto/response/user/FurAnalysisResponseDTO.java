package com.jjh.mtvs.presentation.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "반려동물 털 분석 응답 DTO")
public class FurAnalysisResponseDTO {
    @Schema(description = "반려동물 종류", example = "dog")
    private String breed;

    @Schema(description = "털 색상 인덱스", example = "2")
    private Integer index;

    @Schema(description = "털 색상", example = "white")
    private String color;
}