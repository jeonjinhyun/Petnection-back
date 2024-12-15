package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.mapper.CommunityRoomMapper;
import com.jjh.mtvs.application.service.community.CommunityService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import com.jjh.mtvs.domain.repository.community.CommunitySearchRoomRepository;
import com.jjh.mtvs.domain.repository.user.CommunityFavoriteRepository;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityServiceImpl implements CommunityService {
    private final CommunitySearchRoomRepository communitySearchRoomRepository;
    private final CommunityRoomMapper communityRoomMapper;
    private final UserQueryService userQueryService;
    private final CommunityFavoriteRepository communityFavoriteRepository;

    private CommunityResponseDto mapToResponseWithObjects(CommunityRoom communityRoom, Long userId) {
        CommunityResponseDto dto = communityRoomMapper.toCommunityResponseDto(communityRoom);
        dto.setAuthor(userQueryService.getUserProfileResponseDTO(userId).getName());
        dto.setIsFavorite(communityFavoriteRepository.existsByUserIdAndCommunityRoomId(userId, communityRoom.getId()));
        return dto;
    }
    @Override
    public Page<CommunityResponseDto> searchRecentRooms(Long userId, String keyword, Pageable pageable) {
        Page<CommunityRoom> rooms = communitySearchRoomRepository.findByNameContainingOrderByCreatedAtDesc(keyword, pageable);
            return rooms.map(room -> mapToResponseWithObjects(room, userId));
    }

    @Override
    public Page<CommunityResponseDto> searchFavoriteRooms(Long userId, String keyword, Pageable pageable) {
        return communitySearchRoomRepository.findFavoritesByUserIdAndKeyword(userId, keyword, pageable)
            .map(room -> mapToResponseWithObjects(room, userId));
    }

    @Override
    public Page<CommunityResponseDto> searchMyRooms(Long userId, String keyword, Pageable pageable) {
        return communitySearchRoomRepository.findByCreatorIdAndKeyword(userId, keyword, pageable)
            .map(room -> mapToResponseWithObjects(room, userId));
    }
} 