package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.CommunityRoomMapper;
import com.jjh.mtvs.app.application.mapper.ObjectMapper;
import com.jjh.mtvs.app.application.service.CommunityRoomService;
import com.jjh.mtvs.app.application.service.ObjectService;
import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.community.vo.CommunityRoomAuthority;
import com.jjh.mtvs.app.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.app.domain.repository.CommunityFavoriteRepository;
import com.jjh.mtvs.app.domain.repository.CommunityRoomRepository;
import com.jjh.mtvs.app.presentation.dto.request.CommunityRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.CommunityResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityRoomServiceImpl implements CommunityRoomService {

    private final CommunityRoomRepository communityRoomRepository;
    private final CommunityRoomMapper communityRoomMapper;
    private final ObjectMapper objectMapper;
    private final ObjectService objectService;
    private final CommunityFavoriteRepository communityFavoriteRepository;

    private CommunityResponseDto mapToResponseWithObjects(CommunityRoom communityRoom, Long userId) {
        CommunityResponseDto dto = communityRoomMapper.toCommunityResponseDto(communityRoom);
        dto.setObjectDtos(objectService.getObjectDtosByCommunityRoom(communityRoom));
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
    public Boolean createCommunityRoom(CommunityRequestDto dto) {
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
