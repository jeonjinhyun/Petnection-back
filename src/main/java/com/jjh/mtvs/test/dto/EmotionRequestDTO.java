package com.jjh.mtvs.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EmotionRequestDTO {
    @JsonIgnore
    private MultipartFile image;
    private long user;

    public EmotionRequestDTO(MultipartFile image, long user) {
        this.image = image;
        this.user = user;
    }
}
