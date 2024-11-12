package com.jjh.mtvs.domain.model.user.entity;

import com.jjh.mtvs.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.model.user.vo.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Embedded
    @Setter
    @Column(name = "user_profile")
    private UserProfile profile;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_authority")
    @Enumerated(EnumType.STRING)
    private UserRole authority;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private MyRoom myRoom;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private Gallery gallery;

    public User(String email) {
        this.email = email;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
        if (pet != null) {
            pet.setId(this.id);
        }
    }
    public void setMyRoom(MyRoom myRoom) {
        this.myRoom = myRoom;
        if (myRoom != null) {
            myRoom.setId(this.id);
        }
    }
    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
        if (gallery != null) {
            gallery.setId(this.id);
        }
    }
}