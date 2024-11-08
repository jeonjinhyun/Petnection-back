package com.jjh.mtvs.application.service.myroom;

import com.jjh.mtvs.presentation.dto.common.MyRoomDto;

public interface MyRoomService {
    MyRoomDto getMyRoom(Long userId);
    Boolean updateMyRoom(MyRoomDto dto);
}
