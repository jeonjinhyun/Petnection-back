package com.jjh.mtvs.user.domain.service;

import com.jjh.mtvs.user.presentation.dto.PetDto;

public interface ExternalPetService {
    PetDto getPetByUserId(Long userId);
}
