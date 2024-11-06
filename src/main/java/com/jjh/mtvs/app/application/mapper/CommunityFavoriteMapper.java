package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.app.domain.model.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityFavoriteMapper {
    CommunityFavorite toCommunityFavorite(User user, Long mapId);
}
