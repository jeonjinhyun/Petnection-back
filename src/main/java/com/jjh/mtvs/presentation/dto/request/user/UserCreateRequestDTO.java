package com.jjh.mtvs.presentation.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
@Schema(description = "사용자 요청 DTO")
public class UserCreateRequestDTO {
    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;

    @Schema(description = "이미지 파일", type = "string", format = "binary")
    private MultipartFile imgFile;
}