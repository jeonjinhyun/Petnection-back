package com.jjh.mtvs.user.domain.aggregate.entity;

import com.jjh.mtvs.myroom.domain.aggregate.entity.MyRoom;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_img_url")
    private String imgUrl;

    @Column(name = "user_current_pet_id")
    private Long currentPetId;

    @Column(name = "my_room_id")
    private Long myRoomId;

    @Column(name = "gallery_id")
    private Long galleryId;


    // 받은 친구 요청 목록
    @OneToMany(mappedBy = "receiver")
    private List<Friendship> receivedFriendRequests = new ArrayList<>();

    // 보낸 친구 요청 목록
    @OneToMany(mappedBy = "sender")
    private List<Friendship> sentFriendRequests = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @BatchSize(size = 20)
    @OrderBy("createdAt DESC")  // 최신 즐겨찾기 순으로 정렬
    private Set<UserFavoriteMap> favoriteMapIds = new HashSet<>();


    // 즐겨찾기 추가 메소드
    public void addFavoriteMap(Long mapId) {
        UserFavoriteMap favoriteMap = new UserFavoriteMap(this, mapId);
        this.favoriteMapIds.add(favoriteMap);
    }

    // 즐겨찾기 삭제 메소드
    public void removeFavoriteMap(Long mapId) {
        this.favoriteMapIds.removeIf(favorite -> favorite.getMapId().equals(mapId));
    }



    @Builder
    public User(String email) {
        this.email = email;
    }

    public static User createNewUser(String email) {
        return User.builder()
                .email(email)
                .build();
    }
}
