package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.mapper.CommunityRoomMapper;
import com.jjh.mtvs.application.mapper.ObjectMapper;
import com.jjh.mtvs.application.service.community.CommunityRoomService;
import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;

import com.jjh.mtvs.domain.model.community.vo.CommunityRoomAuthority;
import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.domain.repository.user.CommunityFavoriteRepository;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityRoomServiceImpl implements CommunityRoomService {

    private final CommunityRoomRepository communityRoomRepository;
    private final CommunityRoomMapper communityRoomMapper;
    private final ObjectMapper objectMapper;
    private final CommunityFavoriteRepository communityFavoriteRepository;

    private CommunityResponseDto mapToResponseWithObjects(CommunityRoom communityRoom, Long userId) {
        CommunityResponseDto dto = communityRoomMapper.toCommunityResponseDto(communityRoom);
        dto.setIsFavorite(communityFavoriteRepository.existsByUserIdAndCommunityRoomId(userId, communityRoom.getId()));
        return dto;
    }

    @Override
    public Page<CommunityResponseDto> getFavorites(Long userId, Pageable pageable) {
        Page<CommunityFavorite> favorites = communityFavoriteRepository.findByUserId(userId, pageable);
        return favorites.map(favorite -> mapToResponseWithObjects(favorite.getCommunityRoom(), userId));
    }

    @Override
    public Page<CommunityResponseDto> getRecent(Pageable pageable, Long userId) {  // userId 파라미터 추가
        Page<CommunityRoom> recentCommunityRooms = communityRoomRepository.findAllByOrderByCreatedAtDesc(pageable);
        return recentCommunityRooms.map(communityRoom -> mapToResponseWithObjects(communityRoom, userId));
    }

    @Override
    public Page<CommunityResponseDto> getMyMaps(Long userId, Pageable pageable) {
        Page<CommunityRoom> userCommunityRooms = communityRoomRepository.findByCreatorId(userId, pageable);
        return userCommunityRooms.map(communityRoom -> mapToResponseWithObjects(communityRoom, userId));
    }

    @Override
    public CommunityResponseDto getAdminMap(Long userId) {  // userId 파라미터 추가
        CommunityRoom communityRoom = communityRoomRepository.findOneByCommunityRoomAuthority(CommunityRoomAuthority.ADMIN)
                .orElseThrow(() -> new RuntimeException("관리자룸을 찾을 수 없습니다."));
        return mapToResponseWithObjects(communityRoom, userId);
    }

    @Override
    public Boolean createCommunityRoom(CommunityRequestDTO dto) {
        try {
            CommunityRoom communityRoom = communityRoomMapper.toCommunityRoom(dto);
            dto.getObjectDtos().stream()
                    .map(objectMapper::toObject)
                    .forEach(communityRoom::addCommunityObject);  // 메서드 참조 사용
            communityRoomRepository.save(communityRoom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean deleteCommunityRoom(Long id) {
        try{
            communityRoomRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
