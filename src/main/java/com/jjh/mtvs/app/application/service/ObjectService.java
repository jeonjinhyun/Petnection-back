package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.object.entity.Object;
import com.jjh.mtvs.app.presentation.dto.ObjectDto;

import java.util.List;

public interface ObjectService {
    List<ObjectDto> getObjectDtosByCommunityRoom(CommunityRoom communityRoom);

    List<ObjectDto> getObjectDtosByMyRoom(MyRoom myRoom);
}
