package com.jjh.mtvs.client.application.service;

public interface CommunityFavoriteService {
    Boolean addFavorite(Long userId, Long mapId);
    Boolean removeFavorite(Long userId, Long mapId);
}
