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

    @Mapping(target = "id", ignore = true)  // ID는 업데이트하지 않음
    @Mapping(target = "objects", source = "objectDtos")
    void updateMyRoomFromDto(MyRoomDto dto, @MappingTarget MyRoom myRoom);
}