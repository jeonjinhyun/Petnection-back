package com.jjh.mtvs.client.domain.model.friend.entity;

import com.jjh.mtvs.client.domain.model.friend.vo.FriendInvitationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_friend_invitation")
public class FriendInvitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_invitation_id")
    private Long id;

    @Column(name = "friend_invitation_sender_id")
    private Long senderId;

    @Column(name = "friend_invitation_receiver_id")
    private Long receiverId;

    @Column(name = "friend_invitation_status")
    @Enumerated(EnumType.STRING)
    private FriendInvitationStatus friendInvitationStatus;

    @Column(name = "community_room_id")
    private Long communityRoomId;

    @Column(name = "friend_invitation_requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "friend_invitation_responsed_at")
    private LocalDateTime responsedAt;
}
