package com.jjh.mtvs.pet.domain.repository;

import com.jjh.mtvs.pet.domain.aggregate.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
