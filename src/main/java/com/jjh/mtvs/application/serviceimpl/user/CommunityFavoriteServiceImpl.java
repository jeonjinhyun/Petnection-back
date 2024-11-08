package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.service.user.CommunityFavoriteService;
import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.user.CommunityFavoriteRepository;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityFavoriteServiceImpl implements CommunityFavoriteService {

    private final CommunityFavoriteRepository communityFavoriteRepository;
    private final CommunityRoomRepository communityRoomRepository;
    private final UserRepository userRepository;

    @Override
    public Boolean addFavorite(Long userId, Long mapId) {
        try {
            if (communityFavoriteRepository.existsByUserIdAndCommunityRoomId(userId, mapId)) {
                return false;
            }

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("사용자를 찾는데 실패했습니다."));
            CommunityRoom communityRoom = communityRoomRepository.findById(mapId)
                    .orElseThrow(() -> new RuntimeException("커뮤니티룸을 찾는데 실패했습니다."));
            communityRoom.incrementFavoriteCount();

            CommunityFavorite favorite = new CommunityFavorite(user, communityRoom);
            communityFavoriteRepository.save(favorite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean removeFavorite(Long userId, Long mapId) {
        try {
            CommunityFavorite favorite = communityFavoriteRepository
                    .findByUserIdAndCommunityRoomId(userId, mapId)
                    .orElseThrow(() -> new RuntimeException("즐겨찾기를 찾을 수 없습니다."));

            favorite.getCommunityRoom().decrementFavoriteCount();
            communityFavoriteRepository.delete(favorite);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isFavorite(Long userId, Long mapId) {
        return communityFavoriteRepository.existsByUserIdAndCommunityRoomId(userId, mapId);
    }
}