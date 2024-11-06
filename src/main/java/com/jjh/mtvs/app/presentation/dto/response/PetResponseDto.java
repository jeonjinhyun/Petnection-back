package com.jjh.mtvs.app.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "반려동물 응답 DTO")
public class PetResponseDto {
    @Schema(description = "반려동물 이름", example = "멍멍이")
    private String name;

    @Schema(description = "반려동물 이미지 URL", example = "https://example.com/pet.jpg")
    private String imgUrl;
}
