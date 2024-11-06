package com.jjh.mtvs.app.infrastructure.repository;


import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface JpaUserRepository extends UserRepository, JpaRepository<User,Long> {
}