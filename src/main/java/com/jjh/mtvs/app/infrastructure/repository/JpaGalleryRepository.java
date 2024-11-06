package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.app.domain.repository.GalleryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGalleryRepository extends GalleryRepository, JpaRepository<Gallery, Long> {
}
