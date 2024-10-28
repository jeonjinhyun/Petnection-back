package com.jjh.mtvs.user.domain.service;

import com.jjh.mtvs.user.presentation.dto.loginres.LoginResGalleryDto;

public interface ExternalGalleryService {
    LoginResGalleryDto getGalleryByUserId(Long userId);
}
