package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.MyRoomDto;

public interface MyRoomService {
    MyRoomDto getMyRoom(Long userId);
    Boolean updateMyRoom(MyRoomDto dto);
}
