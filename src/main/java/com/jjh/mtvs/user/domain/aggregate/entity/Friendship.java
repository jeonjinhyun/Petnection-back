package com.jjh.mtvs.user.domain.aggregate.entity;

import com.jjh.mtvs.user.domain.aggregate.entity.enums.FriendshipStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_friendship")
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;

}
