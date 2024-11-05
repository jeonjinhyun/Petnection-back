package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.service.CommunityFavoriteService;
import org.springframework.stereotype.Service;

@Service
public class CommunityFavoriteServiceImpl implements CommunityFavoriteService {
    @Override
    public Boolean addFavorite(Long userId, Long mapId) {
        return null;
    }

    @Override
    public Boolean removeFavorite(Long userId, Long mapId) {
        return null;
    }
}
