package com.jjh.mtvs.client.application.service;


import com.jjh.mtvs.client.presentation.dto.response.LoginResponseDto;

public interface UserAuthService {
    LoginResponseDto login(String email);
}
