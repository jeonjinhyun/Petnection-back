package com.jjh.mtvs.presentation.controller.community;

import com.jjh.mtvs.application.service.community.GoodsService;
import com.jjh.mtvs.presentation.dto.request.community.GoodsRequestDto;
import com.jjh.mtvs.presentation.dto.response.community.GoodsResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/goods")
@Tag(name = "Pet Images", description = "반려동물 이미지 생성 및 조회 API")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    @Operation(summary = "이미지 생성", description = "반려동물 이미지를 기반으로 새로운 이미지를 생성합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GoodsResponseDto> generateImage(
            @Parameter(description = "사용자 ID", required = true)
            @RequestParam Long userId,
            @Parameter(description = "반려동물 이미지", required = true)
            @RequestParam("image") MultipartFile image) {
        GoodsRequestDto requestDTO = new GoodsRequestDto();
        requestDTO.setUserId(userId);
        requestDTO.setImage(image);
        return ResponseEntity.ok(goodsService.generateGoods(requestDTO));
    }

    @Operation(summary = "이미지 목록 조회", description = "사용자의 반려동물 이미지 목록을 조회합니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<Page<GoodsResponseDto>> getImages(
            @Parameter(description = "사용자 ID", required = true)
            @PathVariable Long userId,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(goodsService.getGoodsByUserId(userId, pageable));
    }

}
