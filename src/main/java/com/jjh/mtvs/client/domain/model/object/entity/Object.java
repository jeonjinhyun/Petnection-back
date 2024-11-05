package com.jjh.mtvs.client.domain.model.object.entity;


import com.jjh.mtvs.client.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.client.domain.model.myroom.entity.MyRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "tbl_object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_room_id")
    private MyRoom myRoom;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_room_id")
    private CommunityRoom communityRoom;

    @Column(name = "object_prefab_url", nullable = false)
    private String prefabUrl;

    @Column(name = "object_size", columnDefinition = "json")
    private String size;

    @Column(name = "object_grid_position", columnDefinition = "json")
    private String gridPosition;

    @Column(name = "object_rotate")
    private String rotate;

}