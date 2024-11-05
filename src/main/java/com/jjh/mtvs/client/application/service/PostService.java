package com.jjh.mtvs.client.application.service;

import com.jjh.mtvs.client.presentation.dto.request.PostRequestDto;
import com.jjh.mtvs.client.presentation.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Boolean createPost(PostRequestDto dto);
    Page<PostResponseDto> getPosts(Long communityRoomId, Pageable pageable);
    Boolean deletePost(Long id);
}
