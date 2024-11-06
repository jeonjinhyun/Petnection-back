package com.jjh.mtvs.app.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PetCreateDto {

    @Schema(description = "유저 아이디")
    private Long id;

    @Schema(description = "펫 매쉬 넘버")
    private Integer petMeshNumber;

    @Schema(description = "반려동물 첫번째 사진",type = "file")
    private MultipartFile imgFile;
}
