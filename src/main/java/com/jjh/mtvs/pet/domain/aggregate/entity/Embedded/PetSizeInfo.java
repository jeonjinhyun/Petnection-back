package com.jjh.mtvs.pet.domain.aggregate.entity.Embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PetSizeInfo {
    @Column(name = "pet_tail_length")
    private Float tailLength;      // 반려동물 길이 수치(꼬리)

    @Column(name = "pet_tail_thickness")
    private Float tailThickness;   // 반려동물 굵기 수치(꼬리)

    @Column(name = "pet_head_fat")
    private Float headFat;         // 반려동물 뚱뚱함 수치(머리)

    @Column(name = "pet_head_thin")
    private Float headThin;        // 반려동물 마름 수치(머리)

    @Column(name = "pet_body_thin")
    private Float bodyThin;        // 반려동물 마름 수치(몸통)

    @Column(name = "pet_body_fat")
    private Float bodyFat;         // 반려동물 뚱뚱함 수치(몸통)
}