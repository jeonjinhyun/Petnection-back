package com.jjh.mtvs.domain.repository.community;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunitySearchRoomRepository extends JpaRepository<CommunityRoom, Long> {
    // 1. 최신순 검색 - 커뮤니티 이름으로 검색
    @Query("SELECT cr FROM CommunityRoom cr WHERE cr.name LIKE %:keyword% ORDER BY cr.createdAt DESC")
    Page<CommunityRoom> findByNameContainingOrderByCreatedAtDesc(String keyword, Pageable pageable);

    // 2. 즐겨찾기 목록 내 검색
    @Query("SELECT cr FROM CommunityRoom cr " +
            "JOIN CommunityFavorite cf ON cf.communityRoom.id = cr.id " +
            "WHERE cf.user.id = :userId " +
            "AND cr.name LIKE %:keyword%")
    Page<CommunityRoom> findFavoritesByUserIdAndKeyword(Long userId, String keyword, Pageable pageable);

    // 3. 내가 만든 커뮤니티 검색
    @Query("SELECT cr FROM CommunityRoom cr " +
            "WHERE cr.creatorId = :userId " +
            "AND cr.name LIKE %:keyword%")
    Page<CommunityRoom> findByCreatorIdAndKeyword(Long userId, String keyword, Pageable pageable);
}