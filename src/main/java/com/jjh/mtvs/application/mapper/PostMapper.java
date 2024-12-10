package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.Post;
import com.jjh.mtvs.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.PostResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)  // comments는 서비스에서 처리
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Post toPost(PostRequestDTO dto);

    PostResponseDto toPostResponseDto(Post post);
}