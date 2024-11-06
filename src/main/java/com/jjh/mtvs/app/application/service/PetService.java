package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.response.PetResponseDto;

public interface PetService {
    PetResponseDto getPetDto(Long userId);
}
