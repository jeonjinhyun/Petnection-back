package com.jjh.mtvs.client.domain.model.user.entity;

import com.jjh.mtvs.client.domain.model.user.vo.PetType;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_default_pet")
public class DefaultPet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tbl_default_pet")
    private Long id;

    @Column(name = "default_pet_type")
    private PetType petType;

    @Column(name = "default_pet_texture_url")
    private String textureUrl;
}
