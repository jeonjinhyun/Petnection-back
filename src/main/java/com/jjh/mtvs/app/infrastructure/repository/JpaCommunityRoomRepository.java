package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.repository.CommunityRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommunityRoomRepository extends CommunityRoomRepository , JpaRepository<CommunityRoom, Long> {
}
