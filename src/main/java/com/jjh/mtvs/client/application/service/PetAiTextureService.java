package com.jjh.mtvs.client.application.service;

import org.springframework.web.multipart.MultipartFile;

public interface PetAiTextureService {
    String createPetModel(MultipartFile formData);
}
