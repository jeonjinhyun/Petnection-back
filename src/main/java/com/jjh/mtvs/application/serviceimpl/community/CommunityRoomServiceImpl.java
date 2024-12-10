package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.mapper.CommunityRoomMapper;
import com.jjh.mtvs.application.mapper.ObjectMapper;
import com.jjh.mtvs.application.service.community.CommunityRoomService;
import com.jjh.mtvs.application.service.user.UserAuthService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;

import com.jjh.mtvs.domain.model.community.vo.CommunityRoomAuthority;
import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.domain.repository.user.CommunityFavoriteRepository;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityRoomServiceImpl implements CommunityRoomService {

    private final CommunityRoomRepository communityRoomRepository;
    private final CommunityRoomMapper communityRoomMapper;
    private final ObjectMapper objectMapper;
    private final CommunityFavoriteRepository communityFavoriteRepository;
    private final FileUploadService fileUploadService;
    private final UserQueryService userQueryService;

    private CommunityResponseDto mapToResponseWithObjects(CommunityRoom communityRoom, Long userId) {
        CommunityResponseDto dto = communityRoomMapper.toCommunityResponseDto(communityRoom);
        dto.setAuthor(userQueryService.getUserProfileResponseDTO(userId).getName());
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
    @Transactional
    public Boolean createCommunityRoom(CommunityRequestDTO dto, List<ObjectDto> objectDtos) {
        try {
            // 1. CommunityRoom 생성
            CommunityRoom communityRoom = communityRoomMapper.toCommunityRoom(dto);

            // 2. 파일 처리
            if (dto.getImgFile() != null && !dto.getImgFile().isEmpty()) {
                String imageUrl = fileUploadService.uploadFile(dto.getImgFile());
                communityRoom.setImgUrl(imageUrl);
            }

            communityRoom.getObjects().clear();

            // 3. Objects 처리
            List<Object> objects = new ArrayList<>();
            for (ObjectDto objectDto : objectDtos) {
                Object object = objectMapper.toObject(objectDto);
                objects.add(object);
            }
            communityRoom.setObjects(objects);  // setter를 통해 objects 설정

            // 4. 저장
            communityRoomRepository.save(communityRoom);

            return true;
        } catch (Exception e) {
            log.error("Failed to create community room", e);
            throw new RuntimeException("Failed to create community room", e);
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
