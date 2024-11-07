package com.jjh.mtvs.app.presentation.dto.request.myroom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
@Schema(description = "갤러리 이미지 요청 DTO")
public class GalleryImageRequestDTO {
    @Schema(description = "이미지 ID", example = "1")
    private Long id;

    @Schema(description = "이미지 파일", type = "file")
    private MultipartFile imgFile;
}