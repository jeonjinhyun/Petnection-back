package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.app.domain.repository.GalleryImageRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGalleryImageRepository extends GalleryImageRepository, JpaRepository<GalleryImage,Long> {
}
