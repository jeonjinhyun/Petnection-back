package com.jjh.mtvs.app.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "로그인 응답 DTO")
public class LoginResponseDto {
    @Schema(description = "사용자 ID", example = "1")
    private Long id;

    @Schema(description = "신규 회원 여부", example = "true")
    private Boolean isNewMember;
}