package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User user);

    boolean existsByEmail(String email);

    Optional<User> findById(Long userId);
}
