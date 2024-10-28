package com.jjh.mtvs.user.infrastructure.externalserviceimpl;

import com.jjh.mtvs.user.domain.service.ExternalMyRoomService;
import com.jjh.mtvs.user.presentation.dto.loginres.LoginResMyRoomDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalMyRoomServiceImpl implements ExternalMyRoomService {
    @Override
    public LoginResMyRoomDto getMyRoomByUserId(Long userId) {
        return null;
    }
}
