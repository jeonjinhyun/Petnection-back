package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.PetManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetManagementServiceImpl implements PetManagementService {
    @Override
    public List<String> getDefaultPets() {
        return List.of();
    }
}
