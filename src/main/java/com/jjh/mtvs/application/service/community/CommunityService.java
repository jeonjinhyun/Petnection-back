package com.jjh.mtvs.application.service.community;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;

public interface CommunityService {
    Page<CommunityResponseDto> searchRecentRooms(Long userId, String keyword, Pageable pageable);
    Page<CommunityResponseDto> searchFavoriteRooms(Long userId, String keyword, Pageable pageable);
    Page<CommunityResponseDto> searchMyRooms(Long userId, String keyword, Pageable pageable);
} 