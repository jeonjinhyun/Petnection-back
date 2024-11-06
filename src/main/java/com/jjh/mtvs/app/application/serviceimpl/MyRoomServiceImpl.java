package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.MyRoomMapper;
import com.jjh.mtvs.app.application.mapper.ObjectMapper;
import com.jjh.mtvs.app.application.service.MyRoomService;
import com.jjh.mtvs.app.application.service.ObjectService;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.object.entity.Object;
import com.jjh.mtvs.app.domain.repository.MyRoomRepository;
import com.jjh.mtvs.app.presentation.dto.MyRoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyRoomServiceImpl implements MyRoomService {

    private final MyRoomRepository myRoomRepository;
    private final MyRoomMapper myRoomMapper;
    private final ObjectService objectService;
    private final ObjectMapper objectMapper;

    @Override
    public MyRoomDto getMyRoom(Long userId) {
        MyRoom myRoom = myRoomRepository.findById(userId).orElseThrow(()->new RuntimeException("마이룸을 찾는데 실패했습니다."));
        MyRoomDto response = myRoomMapper.toMyRoomDto(myRoom);
        response.setObjectDtos(objectService.getObjectDtosByMyRoom(myRoom));
        return response;
    }

    @Override
    public Boolean updateMyRoom(MyRoomDto dto) {

        try {
            MyRoom myRoom = myRoomMapper.toMyRoom(dto);
            List<Object> objects = dto.getObjectDtos().stream().map(objectMapper::toObject).toList();
            objects.forEach(myRoom::addObject);
            myRoomRepository.save(myRoom);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
