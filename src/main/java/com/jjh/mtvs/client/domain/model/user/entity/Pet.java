package com.jjh.mtvs.client.domain.model.user.entity;

import com.jjh.mtvs.client.domain.model.user.vo.PetType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tbl_pet")
public class Pet {
    @Id
    @Column(name = "pet_id")
    private Long id;

    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

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

    @Column(name = "pet_body_fat")
    private Float bodyFat;

}