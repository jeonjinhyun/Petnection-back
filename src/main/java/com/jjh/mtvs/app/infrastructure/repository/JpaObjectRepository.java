package com.jjh.mtvs.app.infrastructure.repository;

import com.jjh.mtvs.app.domain.model.object.entity.Object;
import com.jjh.mtvs.app.domain.repository.ObjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaObjectRepository extends ObjectRepository, JpaRepository<Object,Long> {
}
