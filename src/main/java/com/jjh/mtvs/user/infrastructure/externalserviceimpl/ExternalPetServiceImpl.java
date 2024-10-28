package com.jjh.mtvs.user.infrastructure.externalserviceimpl;

import com.jjh.mtvs.user.domain.service.ExternalPetService;
import com.jjh.mtvs.user.presentation.dto.PetDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalPetServiceImpl implements ExternalPetService {
    @Override
    public PetDto getPetByUserId(Long userId) {
        return null;
    }
}
