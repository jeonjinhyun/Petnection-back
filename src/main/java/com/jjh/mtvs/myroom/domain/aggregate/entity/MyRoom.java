package com.jjh.mtvs.myroom.domain.aggregate.entity;

import com.jjh.mtvs.user.domain.aggregate.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_my_room")
@Getter
@NoArgsConstructor
@ToString
public class MyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "my_room_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String roomName;

    @ElementCollection
    @CollectionTable(
            name = "tbl_my_room_object_ids",
            joinColumns = @JoinColumn(name = "my_room_id")
    )
    private List<Long> objectIds = new ArrayList<>();
}
