package com.jjh.mtvs.presentation.dto.response.mainpage;

import com.jjh.mtvs.presentation.dto.common.MyRoomDto;
import com.jjh.mtvs.presentation.dto.common.PetDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "메인 페이지 DTO")
public class MainPageResponseDto {
    @Schema(description = "유저 정보")
    private UserProfileResponseDTO userProfileResponseDto;

    @Schema(description = "반려동물 정보")
    private PetDTO petDTO;

    @Schema(description = "반려동물 이미지")
    private String petImg;

    @Schema(description = "마이룸 정보")
    private MyRoomDto myRoomDto;

    @Schema(description = "커뮤니티 정보")
    private CommunityResponseDto communityResponseDto;
}