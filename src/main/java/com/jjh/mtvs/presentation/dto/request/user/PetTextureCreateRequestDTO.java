package com.jjh.mtvs.presentation.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PetTextureCreateRequestDTO {

    @Schema(description = "유저 아이디")
    private Long id;

    @Schema(description = "펫 매쉬 넘버")
    private Integer petMeshNumber;

    @Schema(description = "이미지 파일", type = "string", format = "binary")
    private MultipartFile imgFile;
}
