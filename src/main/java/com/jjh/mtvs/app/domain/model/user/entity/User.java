package com.jjh.mtvs.app.domain.model.user.entity;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.user.vo.UserAuthority;
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

    @Column(name = "user_authority")
    @Enumerated(EnumType.STRING)
    private UserAuthority authority;

    @Setter
    @Column(name = "user_img_url")
    private String imgUrl;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Pet pet;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private MyRoom myRoom;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Gallery gallery;

    public User(String email) {
        this.email = email;
    }

    @PrePersist
    public void prePersist() {
        if (this.pet == null) {
            this.pet = new Pet();
            this.pet.setUser(this);
        }
        if (this.myRoom == null) {
            this.myRoom = new MyRoom();
            this.myRoom.setUser(this);
        }
        if (this.gallery == null) {
            this.gallery = new Gallery();
            this.gallery.setUser(this);
        }
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

}