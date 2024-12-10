package com.jjh.mtvs.presentation.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Schema(description = "사용자 응답 DTO")
public class UserProfileResponseDTO {
    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;

    @Schema(description = "프로필 이미지 URL", example = "https://example.com/profile.jpg")
    private String imgUrl;
}