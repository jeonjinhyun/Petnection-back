package com.jjh.mtvs.infrastructure.persistence.jpa.repository.myroom;

import com.jjh.mtvs.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.domain.repository.myroom.GalleryImageRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGalleryImageRepository extends GalleryImageRepository, JpaRepository<GalleryImage,Long> {
}
