package com.jjh.mtvs.client.domain.model.myroom.entity;

import com.jjh.mtvs.client.domain.model.object.entity.Object;
import com.jjh.mtvs.client.domain.model.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_my_room")
public class MyRoom {
    @Id
    @Column(name = "my_room_id")
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "myRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Object> objects = new ArrayList<>();

    @OneToMany(mappedBy = "myRoom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gallery> galleries = new ArrayList<>();

    public void addObject(Object object) {
        this.objects.add(object);
        object.setMyRoom(this);
    }

    public void addGallery(Gallery gallery) {
        this.galleries.add(gallery);
        gallery.setMyRoom(this);
    }
}
