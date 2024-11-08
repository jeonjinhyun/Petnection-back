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


    @Column(name = "gallery_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gallery_image_id")
    private List<GalleryImage> images = new ArrayList<>();


    public void addImage(GalleryImage image) {
        this.images.add(image);
    }

    public void removeImageById(Long imageId) {
        this.images.removeIf(image -> image.getId().equals(imageId));
    }

}
