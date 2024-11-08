package com.jjh.mtvs.infrastructure.persistence.jpa.repository.object;

import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.domain.repository.object.ObjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaObjectRepository extends ObjectRepository, JpaRepository<Object,Long> {
}
