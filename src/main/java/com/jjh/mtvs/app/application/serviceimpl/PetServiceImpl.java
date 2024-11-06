package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.PetMapper;
import com.jjh.mtvs.app.application.service.PetService;
import com.jjh.mtvs.app.domain.model.user.entity.Pet;
import com.jjh.mtvs.app.domain.repository.PetRepository;
import com.jjh.mtvs.app.presentation.dto.response.PetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public PetResponseDto getPetDto(Long userId) {
        Pet pet = petRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("펫을 찾는데 실패했습니다."));
        return petMapper.toPetResponseDto(pet);
    }
}
