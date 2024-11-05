package com.jjh.mtvs.client.domain.model.user.entity;

import com.jjh.mtvs.client.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.client.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.client.domain.model.myroom.entity.MyRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Setter
    @Column(name = "user_img_url")
    private String imgUrl;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pet pet;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private MyRoom myRoom;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Gallery gallery;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CommunityFavorite> favorites = new HashSet<>();

    public User(String email) {
        this.email = email;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
        pet.setUser(this);
    }

    public void setMyRoom(MyRoom myRoom) {
        this.myRoom = myRoom;
        myRoom.setUser(this);
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
        gallery.setUser(this);
    }

    public void addFavoriteRoom(CommunityRoom room) {
        CommunityFavorite favorite = new CommunityFavorite(this, room);
        this.favorites.add(favorite);
    }

    public void removeFavoriteRoom(CommunityRoom room) {
        this.favorites.removeIf(favorite ->
                favorite.getCommunityRoom().getId().equals(room.getId())
        );
    }
}