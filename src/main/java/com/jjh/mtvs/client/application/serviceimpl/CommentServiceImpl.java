package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.service.CommentService;
import com.jjh.mtvs.client.presentation.dto.request.CommentRequestDto;
import com.jjh.mtvs.client.presentation.dto.response.CommentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public Long addComment(CommentRequestDto dto) {
        return 0l;
    }

    @Override
    public List<CommentResponseDto> getComments(Long postId) {
        return List.of();
    }

    @Override
    public Boolean deleteComment(Long id) {
        return null;
    }
}
