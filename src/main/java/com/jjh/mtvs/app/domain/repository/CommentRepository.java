package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.community.entity.Comment;

public interface CommentRepository {
    void deleteById(Long id);

    Comment save(Comment comment);

    boolean existsById(Long id);
}
