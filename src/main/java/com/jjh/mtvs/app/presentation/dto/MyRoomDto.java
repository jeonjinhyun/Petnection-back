package com.jjh.mtvs.app.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
@Data
@Schema(description = "마이룸 DTO")
public class MyRoomDto {
    @Schema(description = "마이룸 ID", example = "1")
    private Long id;

    @Schema(description = "오브젝트 목록")
    private List<ObjectDto> objectDtos;
}