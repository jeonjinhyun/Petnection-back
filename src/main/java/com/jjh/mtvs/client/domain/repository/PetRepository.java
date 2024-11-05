package com.jjh.mtvs.client.domain.repository;

import com.jjh.mtvs.client.domain.model.user.entity.Pet;

public interface PetRepository {
    Pet save(Pet pet);
}
