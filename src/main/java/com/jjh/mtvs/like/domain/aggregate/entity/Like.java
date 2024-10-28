package com.jjh.mtvs.like.domain.aggregate.entity;


import com.jjh.mtvs.like.domain.aggregate.entity.embedded.LikeId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.internal.util.collections.LinkedIdentityHashMap;

@Entity
@Table(name = "tbl_like")
public class Like {

    @EmbeddedId
    private LikeId id;
}
