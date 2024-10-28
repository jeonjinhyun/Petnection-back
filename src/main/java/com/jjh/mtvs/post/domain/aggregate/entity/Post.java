package com.jjh.mtvs.post.domain.aggregate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "community_room_id")
    private Long communityRoomId;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_img_url")
    private String imgUrl;
}
