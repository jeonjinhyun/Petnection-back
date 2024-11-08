package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.presentation.dto.common.MyRoomDto;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = ObjectMapper.class)
public interface MyRoomMapper {

    @Mapping(target = "objectDtos", source = "objects")
    MyRoomDto toMyRoomDto(MyRoom myRoom);

    @Mapping(target = "objects", source = "objectDtos")
    MyRoom toMyRoom(MyRoomDto dto);

    @AfterMapping
    default void setMyRoomReference(@MappingTarget MyRoom myRoom, MyRoomDto dto) {
        if (dto.getObjectDtos() != null) {
            dto.getObjectDtos().stream()
                    .map(this::toObject)
                    .forEach(myRoom::addObject);
        }
    }

    Object toObject(ObjectDto objectDto);

}