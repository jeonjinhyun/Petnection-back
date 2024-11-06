package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.community.entity.Comment;
import com.jjh.mtvs.app.domain.model.community.entity.Post;
import com.jjh.mtvs.app.presentation.dto.request.CommentRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.CommentResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMappper {
    Comment toComment(CommentRequestDto dto);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
