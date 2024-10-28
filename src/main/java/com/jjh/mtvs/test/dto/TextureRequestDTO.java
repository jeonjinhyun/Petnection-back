package com.jjh.mtvs.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TextureRequestDTO {
    @JsonIgnore
    private MultipartFile image;
    private Integer petMeshNumber;
    private long userId;

    public TextureRequestDTO(MultipartFile image, Integer petMeshNumber, long userId) {
        this.image = image;
        this.petMeshNumber = petMeshNumber;
        this.userId = userId;
    }
}
