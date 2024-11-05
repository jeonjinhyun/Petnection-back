package com.jjh.mtvs.domain.repository;

import com.jjh.mtvs.domain.model.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User user);

    boolean existsByEmail(String email);

    Optional<User> findById(Long userId);
}
