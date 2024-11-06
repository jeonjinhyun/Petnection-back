package com.jjh.mtvs.app.domain.repository;

import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;

import java.util.Optional;

public interface MyRoomRepository {
    Optional<MyRoom> findById(Long userId);

    MyRoom save(MyRoom myRoom);
}
