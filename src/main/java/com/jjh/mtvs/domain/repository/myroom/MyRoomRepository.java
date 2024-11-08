package com.jjh.mtvs.domain.repository.myroom;

import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;

import java.util.Optional;

public interface MyRoomRepository {
    Optional<MyRoom> findById(Long userId);

    MyRoom save(MyRoom myRoom);
}
