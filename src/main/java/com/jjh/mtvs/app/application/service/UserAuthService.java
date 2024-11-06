package com.jjh.mtvs.app.application.service;


import com.jjh.mtvs.app.presentation.dto.response.LoginResponseDto;

public interface UserAuthService {
    LoginResponseDto login(String email);
}
