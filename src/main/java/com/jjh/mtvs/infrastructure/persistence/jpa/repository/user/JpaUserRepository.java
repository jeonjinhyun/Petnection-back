package com.jjh.mtvs.infrastructure.persistence.jpa.repository.user;


import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaUserRepository extends UserRepository, JpaRepository<User,Long> {
}