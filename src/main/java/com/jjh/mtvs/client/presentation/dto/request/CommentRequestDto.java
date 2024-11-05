package com.jjh.mtvs.client.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Schema(description = "댓글 요청 DTO")
public class CommentRequestDto {
    @Schema(description = "작성자 ID", example = "1")
    private Long author;

    @Schema(description = "내용", example = "좋은 글이네요!")
    private String content;

    @Schema(description = "게시글 ID", example = "1")
    private Long postId;
}