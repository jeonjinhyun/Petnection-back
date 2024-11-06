package com.jjh.mtvs.app.domain.model.community.entity;

import com.jjh.mtvs.app.domain.model.community.vo.CommunityRoomAuthority;
import com.jjh.mtvs.app.domain.model.object.entity.Object;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_community_room")
public class CommunityRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_room_id")
    private Long id;

    @Column(name = "community_room_name", nullable = false)
    private String name;

    @Column(name = "community_room_profile_img_url")
    private String profileImgUrl;

    @Column(name = "community_room_favorite_count")
    private Integer favoriteCount = 0;

    @Column(name = "community_room_authority")
    @Enumerated(EnumType.STRING)
    private CommunityRoomAuthority communityRoomAuthority;

    @OneToMany(mappedBy = "communityRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Column(name = "community_room_creator_id", nullable = false)
    private Long creatorId;

    @Column(name = "community_room_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "community_room_is_favorite")
    private Boolean isFavorite;

    @Setter
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

    public void addCommunityObject(Object object){
        this.objects.add(object);
        object.setCommunityRoom(this);
    }

}