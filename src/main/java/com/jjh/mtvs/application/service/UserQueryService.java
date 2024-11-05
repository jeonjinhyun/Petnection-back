package com.jjh.mtvs.application.service;

import com.jjh.mtvs.presentation.dto.response.UserResponseDto;

public interface UserQueryService {
    public UserResponseDto getUserInfo(Long userId);
}
