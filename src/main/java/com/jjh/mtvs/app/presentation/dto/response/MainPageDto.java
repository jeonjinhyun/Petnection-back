package com.jjh.mtvs.app.presentation.dto.response;

import com.jjh.mtvs.app.presentation.dto.common.UserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "메인 페이지 DTO")
public class MainPageDto {
    @Schema(description = "사용자 정보")
    private UserDto userDto;

    @Schema(description = "커뮤니티 정보")
    private CommunityResponseDto communityResponseDto;
}