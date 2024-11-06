package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.ObjectMapper;
import com.jjh.mtvs.app.application.service.ObjectService;
import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.object.entity.Object;
import com.jjh.mtvs.app.domain.repository.ObjectRepository;
import com.jjh.mtvs.app.presentation.dto.ObjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectServiceImpl implements ObjectService {

    private final ObjectRepository objectRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<ObjectDto> getObjectDtosByCommunityRoom(CommunityRoom communityRoom) {
        List<Object> objects = objectRepository.findByCommunityRoom(communityRoom);
        return objects.stream().map(objectMapper::toObjectDto).toList();
    }

    @Override
    public List<ObjectDto> getObjectDtosByMyRoom(MyRoom myRoom) {
        List<Object> objects = objectRepository.findByMyRoom(myRoom);
        return objects.stream().map(objectMapper::toObjectDto).toList();
    }

}
