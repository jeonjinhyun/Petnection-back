package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.CommunityFavoriteService;
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
