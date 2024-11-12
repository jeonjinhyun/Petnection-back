package com.jjh.mtvs.presentation.dto.common;

import com.jjh.mtvs.common.vo.PetType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "반려동물 요청 DTO")
public class PetDTO {

    @Schema(description = "반려동물 타입", example = "DOG")
    private PetType type;

    @Schema(description = "반려동물 이름", example = "멍멍이")
    private String name;

    @Schema(description = "모델 ID", example = "1")
    private Long modelId;

    @Schema(description = "이별 여부", example = "false")
    private Boolean isFarewelled;

    @Schema(description = "텍스처 URL", example = "https://example.com/texture.png")
    private String textureUrl;

    @Schema(description = "눈 색상", example = "brown")
    private String eyeColors;

    @Schema(description = "코 색상", example = "black")
    private String noseColors;

    @Schema(description = "특징 1", example = "1")
    private Integer feature1;

    @Schema(description = "특징 2", example = "2")
    private Integer feature2;

    @Schema(description = "특징 3", example = "3")
    private Integer feature3;

    @Schema(description = "꼬리 길이", example = "1.0")
    private Float tailLength;

    @Schema(description = "꼬리 두께", example = "0.5")
    private Float tailThickness;

    @Schema(description = "머리 통통함", example = "1.0")
    private Float headFat;

    @Schema(description = "머리 얇음", example = "0.5")
    private Float headThin;

    @Schema(description = "몸 얇음", example = "0.5")
    private Float bodyThin;

    @Schema(description = "몸 통통함", example = "1.0")
    private Float bodyFat;
}