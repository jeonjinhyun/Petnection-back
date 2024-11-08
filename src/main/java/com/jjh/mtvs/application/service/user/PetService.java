package com.jjh.mtvs.application.service.user;

import com.jjh.mtvs.presentation.dto.common.PetDTO;

public interface PetService {
    PetDTO getPetDto(Long userId);
}
