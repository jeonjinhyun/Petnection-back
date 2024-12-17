package com.jjh.mtvs.presentation.dto.response.community;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Schema(description = "커뮤니티 응답 DTO")
public class CommunityResponseDto {
    @Schema(description = "커뮤니티 ID", example = "1")
    private Long id;

    @Schema(description = "커뮤니티 이름", example = "우리 동네 모임")
    private String name;

    @Schema(description = "생성 시간")
    private LocalDateTime createdAt;

    @Schema(description = "작성자 이름", example = "홍길동")
    private String author;

    @Schema(description = "커뮤니티 이미지 URL", example = "https://example.com/community.jpg")
    private String imgUrl;

    @Schema(description = "즐겨찾기 수", example = "42")
    private Integer favoriteCount;

    @Schema(description = "즐겨찾기 여부",example = "true")
    private Boolean isFavorite;

    @Schema(description = "오브젝트 목록")
    private List<ObjectDto> objectDtos;
}