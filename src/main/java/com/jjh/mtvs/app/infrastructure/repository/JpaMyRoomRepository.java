package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.repository.MyRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMyRoomRepository extends MyRoomRepository , JpaRepository<MyRoom, Long> {
}
