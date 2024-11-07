package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.community.entity.Comment;
import com.jjh.mtvs.app.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.CommentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMappper {
    Comment toComment(CommentRequestDTO dto);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
