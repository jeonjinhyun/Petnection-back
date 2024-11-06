package com.jjh.mtvs.app.domain.model.myroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @Setter
    @Column(name = "image_url", nullable = false)
    private String imgUrl;

    @Setter
    @Column(name = "ai_analyze")
    private String aiAnalyze;

    protected void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}