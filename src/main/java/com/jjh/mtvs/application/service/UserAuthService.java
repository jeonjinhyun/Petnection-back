package com.jjh.mtvs.application.service;


import com.jjh.mtvs.presentation.dto.response.LoginResponseDto;

public interface UserAuthService {
    LoginResponseDto login(String email);
}
