package com.jjh.mtvs.client.application.service;

import com.jjh.mtvs.client.presentation.dto.request.CommentRequestDto;
import com.jjh.mtvs.client.presentation.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    Long addComment(CommentRequestDto dto);
    List<CommentResponseDto> getComments(Long postId);
    Boolean deleteComment(Long id);
}
