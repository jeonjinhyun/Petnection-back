package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.service.PetManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetManagementServiceImpl implements PetManagementService {
    @Override
    public List<String> getDefaultPets() {
        return List.of();
    }
}
