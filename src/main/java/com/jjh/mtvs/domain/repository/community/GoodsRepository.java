package com.jjh.mtvs.domain.repository.community;

import com.jjh.mtvs.domain.model.community.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Page<Goods> findByUserIdOrderByIdDesc(Long userId, Pageable pageable);
}
