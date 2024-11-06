package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.facade.MainPageFacadeService;
import com.jjh.mtvs.app.application.service.CommunityRoomService;
import com.jjh.mtvs.app.application.service.UserQueryService;
import com.jjh.mtvs.app.presentation.dto.response.MainPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageFacadeServiceImpl implements MainPageFacadeService {

    private final UserQueryService userQueryService;
    private final CommunityRoomService communityRoomService;

    @Override
    public MainPageDto getMainPage(Long userId) {
        return new MainPageDto(
                userQueryService.getUserDto(userId),
                communityRoomService.getAdminMap(userId)
        );
    }
}
