package com.jjh.mtvs.domain.model.myroom.entity;

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

    @Setter
    @Column(name = "image_url")
    private String imgUrl;

    @Setter
    @Column(name = "ai_analysis", columnDefinition = "TEXT")
    private String aiAnalysis;

}