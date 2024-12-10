package com.jjh.mtvs.presentation.dto.request.community;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class GoodsRequestDto {
    @Schema(description = "사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "반려동물 이미지 파일", type = "string", format = "binary")
    private MultipartFile image;
}
