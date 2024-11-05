package com.jjh.mtvs.client.application.service;

import com.jjh.mtvs.client.presentation.dto.MyRoomDto;

public interface MyRoomService {
    MyRoomDto getMyRoom(Long userId);
    Boolean updateMyRoom(MyRoomDto dto);
}
