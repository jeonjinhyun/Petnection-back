package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.presentation.dto.MyRoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyRoomMapper {
    MyRoomDto toMyRoomDto(MyRoom myRoom);

    MyRoom toMyRoom(MyRoomDto dto);
}
