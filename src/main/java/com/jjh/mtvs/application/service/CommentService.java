package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.request.CommentRequestDto;
import com.jjh.mtvs.presentation.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    Long addComment(CommentRequestDto dto);
    List<CommentResponseDto> getComments(Long postId);
    Boolean deleteComment(Long id);
}
