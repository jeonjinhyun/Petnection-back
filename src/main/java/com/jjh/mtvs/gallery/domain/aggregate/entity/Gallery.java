package com.jjh.mtvs.gallery.domain.aggregate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_gallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id")
    private Long id;

    @Column(name = "gallery_name")
    private String name;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(mappedBy = "galleryId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GalleryImage> galleryImages = new ArrayList<>();
}