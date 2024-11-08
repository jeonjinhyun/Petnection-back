package com.jjh.mtvs.infrastructure.persistence.jpa.repository.user;

import com.jjh.mtvs.domain.model.user.entity.CommunityFavorite;
import com.jjh.mtvs.domain.repository.user.CommunityFavoriteRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommunityFavoriteRepository extends CommunityFavoriteRepository, JpaRepository<CommunityFavorite,Long> {
}
