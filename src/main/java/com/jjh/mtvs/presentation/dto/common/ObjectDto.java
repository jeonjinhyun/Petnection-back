package com.jjh.mtvs.presentation.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "오브젝트 DTO")
public class ObjectDto {

    private Long id;

    @Schema(description = "크기", example = "{\"x\": 10, \"y\": 20}")
    private String size;

    @Schema(description = "그리드 위치", example = "{\"x\": 10, \"y\": 20}")
    private String gridPosition;

    @Schema(description = "회전 값", example = "{\"x\": 10, \"y\": 20}")
    private String rotate;
}