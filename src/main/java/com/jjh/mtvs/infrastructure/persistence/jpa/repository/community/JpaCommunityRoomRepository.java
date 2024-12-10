package com.jjh.mtvs.infrastructure.persistence.jpa.repository.community;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommunityRoomRepository extends CommunityRoomRepository , JpaRepository<CommunityRoom, Long> {
}
