package com.jjh.mtvs.user.presentation.dto.loginres;

import lombok.Data;

@Data
public class LoginResUserDto {
    public Long id;
    public String name;
    public String imgUrl;

    public LoginResUserDto(Long id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }
}
