package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.service.ImageAnalysisService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageAnalysisServiceImpl implements ImageAnalysisService {

    private static final Logger logger = LoggerFactory.getLogger(ImageAnalysisServiceImpl.class);
    private final RestTemplate restTemplate;

    @Override
    public String analyzeImage(MultipartFile multipartFile) {
        try {
            // HTTP 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // 요청 바디 구성
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", new ByteArrayResource(multipartFile.getBytes()) {
                @Override
                public String getFilename() {
                    return multipartFile.getOriginalFilename();
                }
            });

            // HTTP 요청 엔티티 생성
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // API 요청 로깅
            logger.info("Sending image analysis request for file: {}", multipartFile.getOriginalFilename());

            // API 호출
            String IMAGE_ANALYSIS_URL = "https://equal-seasnail-stirred.ngrok-free.app/chatbot/chat";
            ResponseEntity<String> response = restTemplate.exchange(
                    IMAGE_ANALYSIS_URL,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            // 응답 처리
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Image analysis successful");
                return response.getBody();
            } else {
                logger.error("Image analysis failed with status: {}", response.getStatusCode());
                return "이미지 분석에 실패했습니다.";
            }

        } catch (Exception e) {
            logger.error("Error analyzing image", e);
            return "이미지 분석 중 오류가 발생했습니다: " + e.getMessage();
        }
    }
}