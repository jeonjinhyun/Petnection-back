package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.community.entity.Comment;
import com.jjh.mtvs.app.domain.repository.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends CommentRepository, JpaRepository<Comment, Long> {
}
