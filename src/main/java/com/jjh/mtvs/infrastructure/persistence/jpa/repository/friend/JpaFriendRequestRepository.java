package com.jjh.mtvs.infrastructure.persistence.jpa.repository.friend;

import com.jjh.mtvs.domain.model.friend.entity.FriendRequest;
import com.jjh.mtvs.domain.repository.friend.FriendRequestRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFriendRequestRepository extends FriendRequestRepository, JpaRepository<FriendRequest,Long> {
}
