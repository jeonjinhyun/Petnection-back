package com.jjh.mtvs.user.presentation.dto;

import com.jjh.mtvs.pet.domain.aggregate.enums.PetType;

public class PetDto {
    public Long id;
    public String name;
    public String isFarewelled;
    public PetType petType;
    public Integer feature1;
    public Integer feature2;
    public Integer feature3;
    public PetSizeInfoDto petSizeInfoDto;
    public String EyeColors;
    public String noseColors;
}
