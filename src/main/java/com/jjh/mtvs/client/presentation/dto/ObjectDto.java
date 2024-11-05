package com.jjh.mtvs.client.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "오브젝트 DTO")
public class ObjectDto {
    @Schema(description = "오브젝트 ID", example = "1")
    private Long id;

    @Schema(description = "크기", example = "medium")
    private String size;

    @Schema(description = "그리드 위치", example = "1,1")
    private String gridPosition;

    @Schema(description = "회전 값", example = "90")
    private String rotate;

    @Schema(description = "프리팹 URL", example = "https://example.com/prefab.obj")
    private String prefabUrl;
}