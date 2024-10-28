package com.jjh.mtvs.user.domain.service;

import com.jjh.mtvs.user.presentation.dto.loginres.LoginResCommunityRoomDto;

import java.util.List;

public interface ExternalCommunityRoomService {
    List<LoginResCommunityRoomDto> getCommunityRooms();
}
