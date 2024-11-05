package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.service.MyRoomService;
import com.jjh.mtvs.client.presentation.dto.MyRoomDto;
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
