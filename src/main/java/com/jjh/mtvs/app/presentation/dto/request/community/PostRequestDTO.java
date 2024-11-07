package com.jjh.mtvs.app.presentation.dto.request.community;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
@Schema(description = "게시글 요청 DTO")
public class PostRequestDTO {
    @Schema(description = "커뮤니티 룸 ID", example = "1")
    private Long communityRoomId;

    @Schema(description = "작성자 ID", example = "1")
    private Long author;

    @Schema(description = "게시글 이미지", type = "file")
    private MultipartFile imgFile;

    @Schema(description = "제목", example = "오늘의 모임 후기")
    private String title;

    @Schema(description = "내용", example = "오늘 모임이 너무 즐거웠습니다.")
    private String content;
}