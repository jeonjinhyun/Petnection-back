package com.jjh.mtvs.gallery.domain.aggregate.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tbl_gallery_image")
public class GalleryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gallery_id")
    private Gallery galleryId;
}