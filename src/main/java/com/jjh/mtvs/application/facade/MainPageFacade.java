package com.jjh.mtvs.application.facade;

import com.jjh.mtvs.application.service.community.CommunityRoomService;
import com.jjh.mtvs.application.service.myroom.GalleryService;
import com.jjh.mtvs.application.service.myroom.MyRoomService;
import com.jjh.mtvs.application.service.user.PetService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.presentation.dto.response.mainpage.MainPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainPageFacade {

    private final UserQueryService userQueryService;
    private final CommunityRoomService communityRoomService;
    private final MyRoomService myRoomService;
    private final PetService petService;
    private final GalleryService galleryService;


    public MainPageResponseDto getMainPage(Long userId) {
        return new MainPageResponseDto(
                userQueryService.getUserProfileResponseDTO(userId),
                petService.getPetDto(userId),
                galleryService.getGallery(userId).getGalleryImageResponseDtos().get(0).getImgUrl(),
                myRoomService.getMyRoom(userId),
                communityRoomService.getAdminMap(userId)
        );
    }
}
