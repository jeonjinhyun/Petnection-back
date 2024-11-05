package com.jjh.mtvs.infrastructure.repository;

import com.jjh.mtvs.domain.model.user.entity.Pet;
import com.jjh.mtvs.domain.repository.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends PetRepository, JpaRepository<Pet, Long> {

}
