package com.jjh.mtvs.communityroom.domain.aggregate.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_community_room")
public class CommunityRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_room_id")
    private Long id;

    @Column(name = "community_room_Name")
    private String name;

    @Column(name = "community_profile_img_url")
    private String profileImgUrl;

    @Column(name = "community_favorite_count")
    private Integer favoriteCount;

    @ElementCollection
    @CollectionTable(
            name = "tbl_community_room_object_ids",
            joinColumns = @JoinColumn(name = "community_room_id")
    )
    private List<Long> objectIds = new ArrayList<>();

    // ID 추가 메소드
    public void addObjectId(Long objectId) {
        this.objectIds.add(objectId);
    }

    // ID 삭제 메소드
    public void removeObjectId(Long objectId) {
        this.objectIds.remove(objectId);
    }

    // 여러 ID 한번에 추가
    public void addObjectIds(List<Long> newObjectIds) {
        this.objectIds.addAll(newObjectIds);
    }

    // 여러 ID 한번에 삭제
    public void removeObjectIds(List<Long> objectIdsToRemove) {
        this.objectIds.removeAll(objectIdsToRemove);
    }

    // ID 전체 조회
    public List<Long> getObjectIds() {
        return new ArrayList<>(this.objectIds);  // 방어적 복사
    }
}
