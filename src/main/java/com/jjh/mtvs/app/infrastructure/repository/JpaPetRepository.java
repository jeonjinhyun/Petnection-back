package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.user.entity.Pet;
import com.jjh.mtvs.app.domain.repository.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends PetRepository, JpaRepository<Pet, Long> {

}
