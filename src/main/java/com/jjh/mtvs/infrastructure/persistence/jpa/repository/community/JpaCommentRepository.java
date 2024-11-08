package com.jjh.mtvs.infrastructure.persistence.jpa.repository.community;

import com.jjh.mtvs.domain.model.community.entity.Comment;
import com.jjh.mtvs.domain.repository.community.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends CommentRepository, JpaRepository<Comment, Long> {
}
