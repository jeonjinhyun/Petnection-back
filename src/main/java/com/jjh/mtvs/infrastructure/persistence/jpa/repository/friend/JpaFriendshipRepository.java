package com.jjh.mtvs.infrastructure.persistence.jpa.repository.friend;

import com.jjh.mtvs.domain.model.friend.entity.Friendship;
import com.jjh.mtvs.domain.repository.friend.FriendshipRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFriendshipRepository extends FriendshipRepository, JpaRepository<Friendship,Long> {
}
