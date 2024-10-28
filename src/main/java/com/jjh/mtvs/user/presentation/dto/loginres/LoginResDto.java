package com.jjh.mtvs.user.presentation.dto.loginres;

import com.jjh.mtvs.user.presentation.dto.PetDto;
import lombok.Data;
import java.util.List;

@Data
public class LoginResDto {
    private LoginResUserDto loginResUserDto;
    public PetDto petDto;
    public LoginResMyRoomDto loginResMyRoomDto;
    public List<LoginResCommunityRoomDto> loginResCommunityRoomDtos;
    public LoginResGalleryDto loginResGalleryDto;

    public LoginResDto(LoginResUserDto loginResUserDto, PetDto petDto, LoginResMyRoomDto loginResMyRoomDto, List<LoginResCommunityRoomDto> loginResCommunityRoomDtos, LoginResGalleryDto loginResGalleryDto) {
        this.loginResUserDto = loginResUserDto;
        this.petDto = petDto;
        this.loginResMyRoomDto = loginResMyRoomDto;
        this.loginResCommunityRoomDtos = loginResCommunityRoomDtos;
        this.loginResGalleryDto = loginResGalleryDto;
    }
}
