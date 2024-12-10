package com.jjh.mtvs.presentation.controller.community;

import com.jjh.mtvs.application.service.community.CommentService;
import com.jjh.mtvs.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommentResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/comment")
@Tag(name = "Comment", description = "댓글 관련 API")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "댓글 작성", description = "새로운 댓글을 작성합니다.")
    @PostMapping
    public ResponseEntity<Long> addComment(
            @Parameter(description = "댓글 정보", required = true)
            @RequestBody CommentRequestDTO dto) {
        return ResponseEntity.ok(commentService.addComment(dto));
    }

    @Operation(summary = "댓글 목록 조회", description = "게시글의 모든 댓글을 조회합니다.")
    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentResponseDto>> getComments(
            @Parameter(description = "게시글 ID", required = true)
            @PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getComments(postId));
    }

    @Operation(summary = "댓글 삭제", description = "특정 댓글을 삭제합니다.")
    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteComment(
            @Parameter(description = "댓글 ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(commentService.deleteComment(id));
    }
}
