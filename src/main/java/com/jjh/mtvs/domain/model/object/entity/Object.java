package com.jjh.mtvs.domain.model.object.entity;


import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Entity
@Getter
@Setter
@Slf4j
@Table(name = "tbl_object")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_primary_id")
    private Long primaryId;

    @Column(name = "object_id")
    private Long id;

    @Column(name = "object_size", columnDefinition = "json")
    private String size;

    @Column(name = "object_grid_position", columnDefinition = "json")
    private String gridPosition;

    @Column(name = "object_rotate", columnDefinition = "json")
    private String rotate;

    // ID getter/setter에 로깅 추가
    public Long getId() {
        try {
            MDC.put("objectId", String.valueOf(id));
            log.info("Object accessed");
            return id;
        } finally {
            MDC.remove("objectId");
        }
    }

    public void setId(Long id) {
        this.id = id;
        try {
            MDC.put("objectId", String.valueOf(id));
            log.info("Object created/updated");
        } finally {
            MDC.remove("objectId");
        }
    }
}