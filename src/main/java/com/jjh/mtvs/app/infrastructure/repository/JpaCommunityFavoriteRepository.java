package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.app.domain.repository.CommunityFavoriteRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommunityFavoriteRepository extends CommunityFavoriteRepository, JpaRepository<CommunityFavorite,Long> {
}
