package com.jjh.mtvs.user.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user_favorite_map")
public class UserFavoriteMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    @Column(name = "map_id")
    private Long mapId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public UserFavoriteMap(User user, Long mapId) {
        this.user = user;
        this.mapId = mapId;
        this.createdAt = LocalDateTime.now();
    }
}