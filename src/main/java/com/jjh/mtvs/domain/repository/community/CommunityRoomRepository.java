package com.jjh.mtvs.domain.repository.community;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.community.vo.CommunityRoomAuthority;

public interface CommunityRoomRepository {
    Optional<CommunityRoom> findById(Long id);

    CommunityRoom save(CommunityRoom communityRoom);

    void deleteById(Long id);

    Page<CommunityRoom> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<CommunityRoom> findByCreatorId(Long userId, Pageable pageable);

    Optional<CommunityRoom> findOneByCommunityRoomAuthority(CommunityRoomAuthority communityRoomAuthority);
}
