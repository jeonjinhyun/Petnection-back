package com.jjh.mtvs.client.application.service;

import com.jjh.mtvs.client.presentation.dto.response.UserResponseDto;

public interface UserQueryService {
    public UserResponseDto getUserInfo(Long userId);
}
