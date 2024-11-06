package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.MyRoomDto;

public interface MyRoomService {
    MyRoomDto getMyRoom(Long userId);
    Boolean updateMyRoom(MyRoomDto dto);
}
