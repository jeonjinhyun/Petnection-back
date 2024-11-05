package com.jjh.mtvs.domain.repository;

import com.jjh.mtvs.domain.model.user.entity.Pet;

public interface PetRepository {
    Pet save(Pet pet);
}
