package com.jjh.mtvs.presentation.dto.request.myroom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Schema(description = "갤러리 이미지 요청 DTO")
public class GalleryImageRequestDTO {

    @Schema(description = "이미지 ID (수정 시에만 사용)", example = "1")
    private Long id;

    @Schema(description = "이미지 파일", type = "string", format = "binary")
    private MultipartFile imgFile;
}