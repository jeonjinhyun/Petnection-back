package com.jjh.mtvs.domain.repository.myroom;

import com.jjh.mtvs.domain.model.myroom.entity.Gallery;

import java.util.Optional;

public interface GalleryRepository {
    void deleteById(Long id);

    Optional<Gallery> findById(Long id);

    Gallery save(Gallery gallery);
}
