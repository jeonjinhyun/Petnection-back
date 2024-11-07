package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.community.entity.Post;
import com.jjh.mtvs.app.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.PostResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostRequestDTO dto);

    PostResponseDto toPostResponseDto(Post post);
}
