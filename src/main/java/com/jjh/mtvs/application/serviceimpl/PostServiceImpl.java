package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.PostService;
import com.jjh.mtvs.presentation.dto.request.PostRequestDto;
import com.jjh.mtvs.presentation.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public Boolean createPost(PostRequestDto dto) {
        return null;
    }

    @Override
    public Page<PostResponseDto> getPosts(Long communityRoomId, Pageable pageable) {
        return null;
    }

    @Override
    public Boolean deletePost(Long id) {
        return null;
    }
}
