package com.jjh.mtvs.infrastructure.persistence.jpa.repository.myroom;

import com.jjh.mtvs.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.domain.repository.myroom.GalleryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaGalleryRepository extends GalleryRepository, JpaRepository<Gallery, Long> {
}
