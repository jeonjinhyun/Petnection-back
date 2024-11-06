package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.community.entity.Post;
import com.jjh.mtvs.app.domain.repository.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends PostRepository, JpaRepository<Post, Long> {
}
