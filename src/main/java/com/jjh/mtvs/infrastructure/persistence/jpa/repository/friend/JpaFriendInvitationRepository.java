package com.jjh.mtvs.infrastructure.persistence.jpa.repository.friend;

import com.jjh.mtvs.domain.model.friend.entity.FriendInvitation;
import com.jjh.mtvs.domain.repository.friend.FriendInvitationRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaFriendInvitationRepository extends FriendInvitationRepository, JpaRepository<FriendInvitation,Long> {
}
