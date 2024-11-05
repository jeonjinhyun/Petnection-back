package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.service.PetAiTextureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PetAiTextureServiceImpl implements PetAiTextureService {
    @Override
    public String createPetModel(MultipartFile formData) {
        return "";
    }
}
