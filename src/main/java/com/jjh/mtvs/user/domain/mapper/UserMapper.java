package com.jjh.mtvs.user.domain.mapper;

import com.jjh.mtvs.user.domain.aggregate.entity.User;
import com.jjh.mtvs.user.presentation.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .imgUrl(user.getImgUrl())
                .currentPetId(user.getCurrentPetId())
                .myRoomId(user.getMyRoomId())
                .galleryId(user.getGalleryId())
                .build();
    }
}
