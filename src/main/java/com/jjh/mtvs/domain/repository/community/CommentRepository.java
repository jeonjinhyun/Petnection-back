package com.jjh.mtvs.domain.repository.community;

import com.jjh.mtvs.domain.model.community.entity.Comment;

public interface CommentRepository {
    void deleteById(Long id);

    Comment save(Comment comment);

    boolean existsById(Long id);
}
