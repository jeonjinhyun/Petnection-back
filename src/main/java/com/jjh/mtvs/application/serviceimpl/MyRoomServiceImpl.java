package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.MyRoomService;
import com.jjh.mtvs.presentation.dto.MyRoomDto;
import org.springframework.stereotype.Service;

@Service
public class MyRoomServiceImpl implements MyRoomService {
    @Override
    public MyRoomDto getMyRoom(Long userId) {
        return null;
    }

    @Override
    public Boolean updateMyRoom(MyRoomDto dto) {
        return null;
    }
}
