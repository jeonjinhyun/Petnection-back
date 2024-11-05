package com.jjh.mtvs.client.domain.model.community.entity;

import com.jjh.mtvs.client.domain.model.object.entity.Object;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_community_room")
public class CommunityRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_room_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile_img_url")
    private String profileImgUrl;

    @Column(name = "favorite_count")
    private Integer favoriteCount = 0;

    @OneToMany(mappedBy = "communityRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Column(name = "creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "communityRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Object> objects = new ArrayList<>();

    public void incrementFavoriteCount() {
        this.favoriteCount++;
    }

    public void decrementFavoriteCount() {
        if (this.favoriteCount > 0) {
            this.favoriteCount--;
        }
    }

    public void addPost(Post post) {
        this.posts.add(post);
        post.setCommunityRoom(this);
    }
}