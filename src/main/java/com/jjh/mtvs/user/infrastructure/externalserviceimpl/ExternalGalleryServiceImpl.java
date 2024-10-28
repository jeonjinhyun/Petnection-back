package com.jjh.mtvs.user.infrastructure.externalserviceimpl;

import com.jjh.mtvs.user.domain.service.ExternalGalleryService;
import com.jjh.mtvs.user.presentation.dto.loginres.LoginResGalleryDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalGalleryServiceImpl implements ExternalGalleryService {
    @Override
    public LoginResGalleryDto getGalleryByUserId(Long userId) {
        return null;
    }
}
