package com.jjh.mtvs.user.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String imgUrl;
    private Long currentPetId;
    private Long myRoomId;
    private Long galleryId;

    @Builder
    public UserDto(Long id, String name, String email, String imgUrl,
                   Long currentPetId, Long myRoomId, Long galleryId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.imgUrl = imgUrl;
        this.currentPetId = currentPetId;
        this.myRoomId = myRoomId;
        this.galleryId = galleryId;
    }
}
