package com.jjh.mtvs.application.serviceimpl.myroom;

import com.jjh.mtvs.application.service.myroom.ImageAnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageAnalysisServiceImpl implements ImageAnalysisService {

    private final RestTemplate restTemplate;
    private static final String IMAGE_ANALYSIS_URL = "http://221.163.19.142:55508/chatbot/chat";

    @Override
    public String analyzeImage(MultipartFile multipartFile, Long userId) {
        try {
            if (userId == null) {
                throw new IllegalArgumentException("UserId cannot be null");
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", new ByteArrayResource(multipartFile.getBytes()) {
                @Override
                public String getFilename() {
                    return multipartFile.getOriginalFilename();
                }
            });

            // userId를 String으로 명시적 변환
            String url = UriComponentsBuilder.fromHttpUrl(IMAGE_ANALYSIS_URL)
                    .queryParam("user", String.valueOf(userId))  // String.valueOf() 사용
                    .build(false)  // false를 전달하여 인코딩 처리
                    .toUriString();

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            log.info("Sending request to URL: {}", url);
            log.info("Request body: {}", body);
            log.info("Request headers: {}", headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            log.info("Response status: {}", response.getStatusCode());
            log.info("Response body: {}", response.getBody());

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                log.error("Image analysis failed with status: {}", response.getStatusCode());
                return "이미지 분석에 실패했습니다.";
            }

        } catch (IOException e) {
            log.error("Error processing image for analysis", e);
            return "이미지 처리 중 오류가 발생했습니다: " + e.getMessage();
        } catch (Exception e) {
            log.error("Error during image analysis", e);
            return "이미지 분석 중 오류가 발생했습니다: " + e.getMessage();
        }
    }
}