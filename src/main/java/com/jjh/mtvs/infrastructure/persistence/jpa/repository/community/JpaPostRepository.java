package com.jjh.mtvs.infrastructure.persistence.jpa.repository.community;

import com.jjh.mtvs.domain.model.community.entity.Post;
import com.jjh.mtvs.domain.repository.community.PostRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends PostRepository, JpaRepository<Post, Long> {
}
