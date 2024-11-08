package com.jjh.mtvs.application.serviceimpl.myroom;

import com.jjh.mtvs.application.mapper.MyRoomMapper;
import com.jjh.mtvs.application.service.myroom.MyRoomService;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.myroom.MyRoomRepository;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.common.MyRoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class MyRoomServiceImpl implements MyRoomService {

    private final MyRoomRepository myRoomRepository;
    private final MyRoomMapper myRoomMapper;
    private final UserRepository userRepository;


    @Override
    public MyRoomDto getMyRoom(Long userId) {
        MyRoom myRoom = myRoomRepository.findById(userId).orElseThrow(()->new RuntimeException("마이룸을 찾는데 실패했습니다."));
        return myRoomMapper.toMyRoomDto(myRoom);
    }

    @Override
    public Boolean updateMyRoom(MyRoomDto dto) {

        try {
            User user = userRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
            MyRoom newMyRoom = myRoomMapper.toMyRoom(dto);
            user.setMyRoom(newMyRoom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
