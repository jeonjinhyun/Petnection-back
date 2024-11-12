package com.jjh.mtvs.domain.model.user.entity;

import com.jjh.mtvs.common.vo.PetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@ToString
@Setter
@Table(name = "tbl_pet")
public class Pet {
    @Id
    @Setter
    @Column(name = "user_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "pet_type")
    private PetType type;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "pet_model_id")
    private Long modelId;

    @Column(name = "pet_isfarewelled")
    private Boolean isFarewelled;

    @Column(name = "pet_texture_url")
    private String textureUrl;

    @Column(name = "pet_eye_colors", columnDefinition = "json")
    private String eyeColors;

    @Column(name = "pet_nose_colors", columnDefinition = "json")
    private String noseColors;

    @Column(name = "pet_feature1")
    private Integer feature1;

    @Column(name = "pet_feature2")
    private Integer feature2;

    @Column(name = "pet_feature3")
    private Integer feature3;

    @Column(name = "pet_tail_length")
    private Float tailLength;

    @Column(name = "pet_tail_thickness")
    private Float tailThickness;

    @Column(name = "pet_head_fat")
    private Float headFat;

    @Column(name = "pet_head_thin")
    private Float headThin;

    @Column(name = "pet_body_thin")
    private Float bodyThin;

    public Pet(Long id, PetType type, String name, Long modelId, Boolean isFarewelled, String textureUrl, String eyeColors, String noseColors, Integer feature1, Integer feature2, Integer feature3, Float tailLength, Float tailThickness, Float headFat, Float headThin, Float bodyThin, Float bodyFat) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.modelId = modelId;
        this.isFarewelled = isFarewelled;
        this.textureUrl = textureUrl;
        this.eyeColors = eyeColors;
        this.noseColors = noseColors;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
        this.tailLength = tailLength;
        this.tailThickness = tailThickness;
        this.headFat = headFat;
        this.headThin = headThin;
        this.bodyThin = bodyThin;
        this.bodyFat = bodyFat;
    }

    @Column(name = "pet_body_fat")
    private Float bodyFat;

}