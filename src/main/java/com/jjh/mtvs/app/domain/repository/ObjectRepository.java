package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.object.entity.Object;

import java.util.List;

public interface ObjectRepository {
    List<Object> findByCommunityRoom(CommunityRoom communityRoom);

    List<Object> findByMyRoom(MyRoom myRoom);
}
