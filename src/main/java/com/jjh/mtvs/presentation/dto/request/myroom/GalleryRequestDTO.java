package com.jjh.mtvs.presentation.dto.request.myroom;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
@Schema(description = "갤러리 요청 DTO")
public class GalleryRequestDTO {

    @Schema(description = "사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "갤러리 이름", example = "나의 갤러리")
    private String name;

    private List<GalleryImageRequestDTO> galleryImages;
}