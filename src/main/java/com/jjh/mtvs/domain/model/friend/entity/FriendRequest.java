package com.jjh.mtvs.domain.model.friend.entity;
import com.jjh.mtvs.domain.model.friend.vo.FriendRequestStatus;
import com.jjh.mtvs.domain.model.user.entity.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_friend_request")
@NoArgsConstructor
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friend_request_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private FriendRequestStatus status;
    @Column(name = "friend_requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "friend_responsed_at")
    private LocalDateTime responsedAt;


}
