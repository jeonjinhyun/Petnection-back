package com.jjh.mtvs.app.presentation.dto;

import com.jjh.mtvs.app.presentation.dto.response.PetResponseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "사용자 정보 DTO")
public class UserDto {
    @Schema(description = "사용자 이름", example = "홍길동")
    private String name;

    @Schema(description = "프로필 이미지 URL", example = "https://example.com/profile.jpg")
    private String imgUrl;

    @Schema(description = "반려동물 정보")
    private PetResponseDto petResponseDto;

    @Schema(description = "마이룸 정보")
    private MyRoomDto myRoomDto;
}
