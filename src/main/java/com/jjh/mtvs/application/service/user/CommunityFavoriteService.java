package com.jjh.mtvs.application.service.user;

public interface CommunityFavoriteService {
    Boolean addFavorite(Long userId, Long mapId);
    Boolean removeFavorite(Long userId, Long mapId);
    Boolean isFavorite(Long userId,Long mapId);
}
