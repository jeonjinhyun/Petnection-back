package com.jjh.mtvs.application.service.user;

import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;

public interface UserQueryService {
    UserProfileResponseDTO getUserProfileResponseDTO(Long userId);
    User getUser(Long userId);
}
