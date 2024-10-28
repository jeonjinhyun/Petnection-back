package com.jjh.mtvs.user.domain.service;

import com.jjh.mtvs.user.presentation.dto.loginres.LoginResMyRoomDto;

public interface ExternalMyRoomService {
    LoginResMyRoomDto getMyRoomByUserId(Long userId);
}
