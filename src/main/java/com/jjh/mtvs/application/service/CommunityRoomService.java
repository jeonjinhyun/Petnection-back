package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.request.CommunityRequestDto;
import com.jjh.mtvs.presentation.dto.response.CommunityResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityRoomService {
    Page<CommunityResponseDto> getFavorites(Long userId, Pageable pageable);
    Page<CommunityResponseDto> getRecent(Pageable pageable);
    Page<CommunityResponseDto> getMyMaps(Long userId, Pageable pageable);
    Boolean createCommunityRoom(CommunityRequestDto dto);
    Boolean deleteCommunityRoom(Long id);
}
