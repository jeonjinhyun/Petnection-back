package com.jjh.mtvs.app.application.service;

public interface CommunityFavoriteService {
    Boolean addFavorite(Long userId, Long mapId);
    Boolean removeFavorite(Long userId, Long mapId);
    Boolean isFavorite(Long userId,Long mapId);
}
