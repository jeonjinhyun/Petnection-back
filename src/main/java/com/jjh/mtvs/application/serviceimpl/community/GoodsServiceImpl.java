package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.service.community.GoodsService;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.domain.model.community.entity.Goods;
import com.jjh.mtvs.domain.repository.community.GoodsRepository;
import com.jjh.mtvs.presentation.dto.request.community.GoodsRequestDto;
import com.jjh.mtvs.presentation.dto.response.community.GoodsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final FileUploadService fileUploadService;
    private final RestTemplate restTemplate;

    @Override
    public GoodsResponseDto generateGoods(GoodsRequestDto goodsRequestDto) {
        try {
            // 1. 원본 이미지 저장
            String originalImageUrl = fileUploadService.uploadFile(goodsRequestDto.getImage());

            // 2. AI 서버로 이미지 전송
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", goodsRequestDto.getImage().getResource());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // 3. AI 서버로부터 이미지 생성
            String aiServiceUrl = "http://221.163.19.142:55508/SD15/gen_image";
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    aiServiceUrl,
                    HttpMethod.POST,
                    requestEntity,
                    byte[].class
            );

            // 4. 생성된 이미지를 파일로 저장
            String fileName = "generated_" + System.currentTimeMillis() + ".png";
            MultipartFile generatedImageFile = new MockMultipartFile(
                    fileName,
                    fileName,
                    MediaType.IMAGE_PNG_VALUE,
                    response.getBody()
            );

            String generatedImageUrl = fileUploadService.uploadFile(generatedImageFile);

            // 5. DB에 정보 저장
            Goods goods = new Goods();
            goods.setUserId(goodsRequestDto.getUserId());
            goods.setOriginalImageUrl(originalImageUrl);
            goods.setGeneratedImageUrl(generatedImageUrl);

            goods = goodsRepository.save(goods);

            // 6. 응답 생성
            GoodsResponseDto responseDTO = new GoodsResponseDto();
            responseDTO.setId(goods.getId());
            responseDTO.setOriginalImageUrl(goods.getOriginalImageUrl());
            responseDTO.setGeneratedImageUrl(goods.getGeneratedImageUrl());

            return responseDTO;

        } catch (Exception e) {
            log.error("Error generating image:", e);
            throw new RuntimeException("Failed to generate image", e);
        }
    }

    @Override
    @Transactional
    public Page<GoodsResponseDto> getGoodsByUserId(Long userId, Pageable pageable) {
        return goodsRepository.findByUserIdOrderByIdDesc(userId, pageable)
                .map(goods -> {
                    GoodsResponseDto dto = new GoodsResponseDto();
                    dto.setId(goods.getId());
                    dto.setOriginalImageUrl(goods.getOriginalImageUrl());
                    dto.setGeneratedImageUrl(goods.getGeneratedImageUrl());
                    return dto;
                });
    }
}
