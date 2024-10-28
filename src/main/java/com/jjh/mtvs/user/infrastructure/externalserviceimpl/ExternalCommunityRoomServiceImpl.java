package com.jjh.mtvs.user.infrastructure.externalserviceimpl;

import com.jjh.mtvs.user.domain.service.ExternalCommunityRoomService;
import com.jjh.mtvs.user.presentation.dto.loginres.LoginResCommunityRoomDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalCommunityRoomServiceImpl implements ExternalCommunityRoomService {
    @Override
    public List<LoginResCommunityRoomDto> getCommunityRooms() {
        return List.of();
    }
}
