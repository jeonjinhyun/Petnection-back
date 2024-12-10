package com.jjh.mtvs.infrastructure.persistence.jpa.repository.myroom;

import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.repository.myroom.MyRoomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMyRoomRepository extends MyRoomRepository , JpaRepository<MyRoom, Long> {
}
