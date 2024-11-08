package com.jjh.mtvs.domain.repository.user;

import com.jjh.mtvs.domain.model.user.entity.Pet;

import java.util.Optional;

public interface PetRepository {
    Pet save(Pet pet);

    Optional<Pet> findById(Long userId);
}
