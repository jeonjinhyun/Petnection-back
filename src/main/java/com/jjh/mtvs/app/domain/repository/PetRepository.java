package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.user.entity.Pet;

import java.util.Optional;

public interface PetRepository {
    Pet save(Pet pet);

    Optional<Pet> findById(Long userId);
}
