package com.jjh.mtvs.domain.repository.user;

import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CommunityFavoriteRepository {
    CommunityFavorite save(CommunityFavorite favorite);

    void delete(CommunityFavorite favorite);

    Optional<CommunityFavorite> findByUserIdAndCommunityRoomId(Long userId, Long mapId);

    boolean existsByUserIdAndCommunityRoomId(Long userId, Long mapId);

    Page<CommunityFavorite> findByUserId(Long userId, Pageable pageable);
}
