package com.jjh.mtvs.application.service.user;


import com.jjh.mtvs.presentation.dto.request.auth.LoginRequestDTO;
import com.jjh.mtvs.presentation.dto.response.auth.LoginResponseDTO;

public interface UserAuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
