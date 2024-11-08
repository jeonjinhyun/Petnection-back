package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.mapper.PetMapper;
import com.jjh.mtvs.application.service.user.PetService;
import com.jjh.mtvs.domain.model.user.entity.Pet;
import com.jjh.mtvs.domain.repository.user.PetRepository;
import com.jjh.mtvs.presentation.dto.common.PetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public PetDTO getPetDto(Long userId) {
        Pet pet = petRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("펫을 찾는데 실패했습니다."));
        return petMapper.toPetDTO(pet);
    }
}
