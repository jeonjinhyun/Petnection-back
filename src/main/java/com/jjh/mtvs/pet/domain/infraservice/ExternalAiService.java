package com.jjh.mtvs.pet.domain.infraservice;

import com.jjh.mtvs.pet.presentation.dto.AITextureResDto;
import org.springframework.web.multipart.MultipartFile;

public interface ExternalAiService {
    AITextureResDto getTexture(MultipartFile imageFile) throws Exception;
}
