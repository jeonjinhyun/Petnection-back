package com.jjh.mtvs.domain.model.myroom.entity;

import com.jjh.mtvs.domain.model.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_gallery")
public class Gallery {
    @Id
    @Column(name = "gallery_id")
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_room_id")
    private MyRoom myRoom;

    @Column(name = "gallery_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GalleryImage> images = new ArrayList<>();

    protected void setMyRoom(MyRoom myRoom) {
        this.myRoom = myRoom;
    }

    public void addImage(GalleryImage image) {
        this.images.add(image);
        image.setGallery(this);
    }
}
