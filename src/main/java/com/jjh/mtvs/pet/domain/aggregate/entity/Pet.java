package com.jjh.mtvs.pet.domain.aggregate.entity;

import com.jjh.mtvs.pet.domain.aggregate.entity.Embedded.PetSizeInfo;
import com.jjh.mtvs.pet.domain.aggregate.entity.Embedded.PetId;
import com.jjh.mtvs.pet.domain.aggregate.enums.PetType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_pet")
@Getter
@Setter
@NoArgsConstructor
public class Pet {

    @EmbeddedId
    private PetId id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "pet_isfarewlled")
    private Boolean isFarewelled;

    @Embedded
    private PetSizeInfo sizeInfo;  // @Embedded 추가

    @Column(name = "pet_texture_url")
    private String textureUrl;

    @Column(name = "pet_feature1")
    private Integer feature1;

    @Column(name = "pet_feature2")
    private Integer feature2;

    @Column(name = "pet_feature3")
    private Integer feature3;

    @Column(name = "pet_eye_colors", columnDefinition = "json")
    private String eyeColors;

    @Column(name = "pet_nose_colors", columnDefinition = "json")
    private String noseColors;

    @Builder
    public Pet(PetId id, Long userId, String textureUrl) {
        this.id = id;
        this.userId = userId;
        this.textureUrl = textureUrl;
    }
}