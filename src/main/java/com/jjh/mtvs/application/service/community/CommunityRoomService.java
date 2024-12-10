package com.jjh.mtvs.application.service.community;

import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityRoomService {
    Page<CommunityResponseDto> getFavorites(Long userId, Pageable pageable);
    Page<CommunityResponseDto> getRecent(Pageable pageable,Long id);
    Page<CommunityResponseDto> getMyMaps(Long userId, Pageable pageable);
    Boolean createCommunityRoom(CommunityRequestDTO dto, List<ObjectDto> objectDtos);
    Boolean deleteCommunityRoom(Long id);
    CommunityResponseDto getAdminMap(Long id);
}
