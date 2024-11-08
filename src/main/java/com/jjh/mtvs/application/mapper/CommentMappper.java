package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.Comment;
import com.jjh.mtvs.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMappper {
    Comment toComment(CommentRequestDTO dto);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
