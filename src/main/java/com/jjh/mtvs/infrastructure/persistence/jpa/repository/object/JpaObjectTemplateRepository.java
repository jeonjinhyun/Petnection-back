package com.jjh.mtvs.infrastructure.persistence.jpa.repository.object;

import com.jjh.mtvs.domain.model.object.entity.ObjectTemplate;
import com.jjh.mtvs.domain.repository.object.ObjectTemplateRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaObjectTemplateRepository extends ObjectTemplateRepository, JpaRepository<ObjectTemplate,Long> {
}
