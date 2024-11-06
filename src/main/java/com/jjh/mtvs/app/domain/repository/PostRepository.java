package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.community.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    void deleteById(Long id);

    Page<Post> findByCommunityRoomId(Long communityRoomId, Pageable pageable);

    Optional<Post> findById(Long postId);

}
