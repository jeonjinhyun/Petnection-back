package com.jjh.mtvs.client.infrastructure.repository;

import com.jjh.mtvs.client.domain.model.user.entity.Pet;
import com.jjh.mtvs.client.domain.repository.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends PetRepository, JpaRepository<Pet, Long> {

}
