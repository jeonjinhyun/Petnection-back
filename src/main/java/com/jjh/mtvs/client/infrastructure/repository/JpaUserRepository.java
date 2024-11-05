package com.jjh.mtvs.client.infrastructure.repository;


import com.jjh.mtvs.client.domain.model.user.entity.User;
import com.jjh.mtvs.client.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends UserRepository, JpaRepository<User,Long> {
    @Override
    Optional<User> findByEmail(String email);

    @Override
    Optional<User> findById(Long id);
}
