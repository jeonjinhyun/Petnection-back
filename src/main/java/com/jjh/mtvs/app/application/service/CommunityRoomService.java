package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.CommunityResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityRoomService {
    Page<CommunityResponseDto> getFavorites(Long userId, Pageable pageable);
    Page<CommunityResponseDto> getRecent(Pageable pageable,Long id);
    Page<CommunityResponseDto> getMyMaps(Long userId, Pageable pageable);
    Boolean createCommunityRoom(CommunityRequestDTO dto);
    Boolean deleteCommunityRoom(Long id);
    CommunityResponseDto getAdminMap(Long id);
}
