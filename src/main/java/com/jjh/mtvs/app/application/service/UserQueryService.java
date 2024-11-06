package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.presentation.dto.UserDto;
import com.jjh.mtvs.app.presentation.dto.response.UserResponseDto;

public interface UserQueryService {
    public UserResponseDto getUserResponseDto(Long userId);

    public UserDto getUserDto(Long userId);

    User getUser(Long userId);
}
