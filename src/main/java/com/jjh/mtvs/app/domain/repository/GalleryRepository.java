package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.myroom.entity.Gallery;

import java.util.Optional;

public interface GalleryRepository {
    void deleteById(Long id);

    Optional<Gallery> findById(Long id);

    Gallery save(Gallery gallery);
}
