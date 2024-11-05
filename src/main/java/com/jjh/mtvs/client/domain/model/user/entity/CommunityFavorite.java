package com.jjh.mtvs.client.domain.model.user.entity;

import com.jjh.mtvs.client.domain.model.community.entity.CommunityRoom;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_community_favorite",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id", "community_room_id"}
                )
        })
public class CommunityFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_room_id", nullable = false)
    private CommunityRoom communityRoom;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public CommunityFavorite(User user, CommunityRoom communityRoom) {
        this.user = user;
        this.communityRoom = communityRoom;
        communityRoom.incrementFavoriteCount();
    }
}