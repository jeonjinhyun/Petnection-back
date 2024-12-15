package com.jjh.mtvs.presentation.dto.response.community;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "게시글 응답 DTO")
public class PostResponseDto {
    @Schema(description = "게시글 ID", example = "1")
    private Long id;

    @Schema(description = "제목", example = "오늘의 모임 후기")
    private String title;

    @Schema(description = "내용", example = "오늘 모임이 너무 즐거웠습니다.")
    private String content;

    @Schema(description = "이미지 URL", example = "https://example.com/post.jpg")
    private String imgUrl;

    @Schema(description = "작성자 이름", example = "홍길동")
    private String authorName;

    private LocalDateTime createdAt;
}