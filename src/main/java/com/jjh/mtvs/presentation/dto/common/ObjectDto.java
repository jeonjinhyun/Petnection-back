package com.jjh.mtvs.presentation.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "오브젝트 DTO")
public class ObjectDto {

    @Schema(description = "크기", example = "medium")
    private String size;

    @Schema(description = "그리드 위치", example = "1,1")
    private String gridPosition;

    @Schema(description = "회전 값", example = "90")
    private String rotate;
}