package com.jjh.mtvs.application.serviceimpl.myroom;

import com.jjh.mtvs.application.mapper.MyRoomMapper;
import com.jjh.mtvs.application.service.myroom.MyRoomService;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.myroom.MyRoomRepository;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.common.MyRoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class MyRoomServiceImpl implements MyRoomService {

    private final MyRoomRepository myRoomRepository;
    private final MyRoomMapper myRoomMapper;


    @Override
    public MyRoomDto getMyRoom(Long userId) {
        MyRoom myRoom = myRoomRepository.findById(userId).orElseThrow(()->new RuntimeException("마이룸을 찾는데 실패했습니다."));
        return myRoomMapper.toMyRoomDto(myRoom);
    }
    @Override
    @Transactional
    public Boolean updateMyRoom(MyRoomDto dto) {
        try {
            MyRoom myRoom = myRoomRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("마이룸을 찾는데 실패했습니다."));
            myRoom.getObjects().clear();
            myRoomMapper.updateMyRoomFromDto(dto, myRoom);
            myRoomRepository.save(myRoom);
            return true;
        } catch (Exception e) {
            log.error("Failed to update myroom", e);
            throw new RuntimeException("마이룸 수정 중 오류가 발생했습니다.", e);
        }
    }
}
