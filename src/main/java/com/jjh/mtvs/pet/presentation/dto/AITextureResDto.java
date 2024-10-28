package com.jjh.mtvs.pet.presentation.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class AITextureResDto {
    public Long petModelId;
    private MultipartFile textureFile;
}
