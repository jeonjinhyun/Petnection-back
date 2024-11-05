package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.service.CommunityRoomService;
import com.jjh.mtvs.client.presentation.dto.request.CommunityRequestDto;
import com.jjh.mtvs.client.presentation.dto.response.CommunityResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommunityRoomServiceImpl implements CommunityRoomService {
    @Override
    public Page<CommunityResponseDto> getFavorites(Long userId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<CommunityResponseDto> getRecent(Pageable pageable) {
        return null;
    }

    @Override
    public Page<CommunityResponseDto> getMyMaps(Long userId, Pageable pageable) {
        return null;
    }

    @Override
    public Boolean createCommunityRoom(CommunityRequestDto dto) {
        return null;
    }

    @Override
    public Boolean deleteCommunityRoom(Long id) {
        return null;
    }
}
