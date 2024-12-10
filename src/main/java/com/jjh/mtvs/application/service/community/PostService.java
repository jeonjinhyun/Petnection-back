package com.jjh.mtvs.application.service.community;

import com.jjh.mtvs.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Boolean createPost(PostRequestDTO dto);
    Page<PostResponseDto> getPostsByCommunityRoomId(Long communityRoomId, Pageable pageable);
    Boolean deletePost(Long id);
}
