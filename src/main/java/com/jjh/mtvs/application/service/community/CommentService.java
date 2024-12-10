package com.jjh.mtvs.application.service.community;

import com.jjh.mtvs.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommentResponseDto;

import java.util.List;

public interface CommentService {
    Long addComment(CommentRequestDTO dto);
    List<CommentResponseDto> getComments(Long postId);
    Boolean deleteComment(Long id);
}
