package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.Post;
import com.jjh.mtvs.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.PostResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostRequestDTO dto);

    PostResponseDto toPostResponseDto(Post post);
}
