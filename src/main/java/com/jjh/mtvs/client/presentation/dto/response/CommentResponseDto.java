package com.jjh.mtvs.client.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "댓글 응답 DTO")
public class CommentResponseDto {
    @Schema(description = "댓글 ID", example = "1")
    private Long id;

    @Schema(description = "작성자 정보")
    private UserResponseDto userResponseDto;

    @Schema(description = "내용", example = "좋은 글이네요!")
    private String content;
}