package com.jjh.mtvs.object.domain.aggregate.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_object")
public class Object{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "object_size",columnDefinition = "json")
    private String size;

    @Column(name = "object_grid_position",columnDefinition = "json")
    private String gridPosition;

    @Column(name = "object_rotate")
    private String rotate;

    @Column(name = "object_prefab_url")
    private String prefabUrl;
}