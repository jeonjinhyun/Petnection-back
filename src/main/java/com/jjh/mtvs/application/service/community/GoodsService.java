package com.jjh.mtvs.application.service.community;

import com.jjh.mtvs.presentation.dto.request.community.GoodsRequestDto;
import com.jjh.mtvs.presentation.dto.response.community.GoodsResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GoodsService {
    GoodsResponseDto generateGoods(GoodsRequestDto goodsRequestDto);

    Page<GoodsResponseDto> getGoodsByUserId(Long userId, Pageable pageable);
}
