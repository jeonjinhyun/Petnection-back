package com.jjh.mtvs.domain.repository.community;

import aj.org.objectweb.asm.commons.Remapper;
import com.jjh.mtvs.domain.model.community.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    void deleteById(Long id);

    Optional<Post> findById(Long postId);
}
