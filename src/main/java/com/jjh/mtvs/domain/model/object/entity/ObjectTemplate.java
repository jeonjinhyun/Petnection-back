package com.jjh.mtvs.domain.model.object.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ObjectTemplate {
    @Id
    @Column
    private Long id;
}
