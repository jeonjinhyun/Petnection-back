package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.Comment;
import com.jjh.mtvs.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMappper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Comment toComment(CommentRequestDTO dto);

    CommentResponseDto toCommentResponseDto(Comment comment);
}
