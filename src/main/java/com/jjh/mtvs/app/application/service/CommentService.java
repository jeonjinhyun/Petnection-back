package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    Long addComment(CommentRequestDTO dto);
    List<CommentResponseDto> getComments(Long postId);
    Boolean deleteComment(Long id);
}
