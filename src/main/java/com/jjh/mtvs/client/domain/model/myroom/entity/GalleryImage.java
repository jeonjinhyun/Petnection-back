package com.jjh.mtvs.client.domain.model.myroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_gallery_image")
public class GalleryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_image_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    @Column(name = "image_url", nullable = false)
    private String imgUrl;

    @Column(name = "ai_analyze")
    private String aiAnalyze;

    protected void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}