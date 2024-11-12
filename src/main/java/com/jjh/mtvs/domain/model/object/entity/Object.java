package com.jjh.mtvs.domain.model.object.entity;


import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Long id;

    @Column(name = "object_size", columnDefinition = "json")
    private String size;

    @Column(name = "object_grid_position", columnDefinition = "json")
    private String gridPosition;

    @Column(name = "object_rotate", columnDefinition = "json")
    private String rotate;
}