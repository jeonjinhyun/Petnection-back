package com.jjh.mtvs.app.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원가입 사용자 DTO")
public class JoinUserDto {
    @Schema(description = "사용자 요청 정보")
    private UserRequestDto userRequestDto;

    @Schema(description = "반려동물 요청 정보")
    private PetRequestDto petRequestDto;
}