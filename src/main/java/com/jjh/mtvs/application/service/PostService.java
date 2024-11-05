package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.request.PostRequestDto;
import com.jjh.mtvs.presentation.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Boolean createPost(PostRequestDto dto);
    Page<PostResponseDto> getPosts(Long communityRoomId, Pageable pageable);
    Boolean deletePost(Long id);
}
