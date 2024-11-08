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

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "user_authority")
    @Enumerated(EnumType.STRING)
    private UserRole authority;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pet_id", referencedColumnName = "user_id")
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "my_room_id", referencedColumnName = "user_id")
    private MyRoom myRoom;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gallery_id", referencedColumnName = "user_id")
    private Gallery gallery;

    public User(String email) {
        this.email = email;
        this.pet = new Pet();
        this.myRoom = new MyRoom();
        this.gallery = new Gallery();
    }
}