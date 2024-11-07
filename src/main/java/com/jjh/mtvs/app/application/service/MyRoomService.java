package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.common.MyRoomDto;

public interface MyRoomService {
    MyRoomDto getMyRoom(Long userId);
    Boolean updateMyRoom(MyRoomDto dto);
}
