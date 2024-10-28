package com.jjh.mtvs.test.service;

import com.jjh.mtvs.test.dto.EmotionRequestDTO;
import com.jjh.mtvs.test.dto.TextureRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class AIService {
    private static final Logger logger = LoggerFactory.getLogger(AIService.class);

    private final String AI_SERVICE_URL_1 = "https://equal-seasnail-stirred.ngrok-free.app/chatbot/chat";
    private final String AI_SERVICE_URL_2 = "https://sheepdog-bold-bulldog.ngrok-free.app/texture/img2texture";
    private final RestTemplate restTemplate;

    public AIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Async
    public CompletableFuture<String> sendEmotion(EmotionRequestDTO emotionRequestDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", new ByteArrayResource(emotionRequestDTO.getImage().getBytes()) {
                @Override
                public String getFilename() {
                    return emotionRequestDTO.getImage().getOriginalFilename();
                }
            });

            String url = UriComponentsBuilder.fromHttpUrl(AI_SERVICE_URL_1)
                    .queryParam("user", emotionRequestDTO.getUser())
                    .toUriString();

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            logger.info("Sending request to URL: {}", url);
            logger.info("Request body: {}", body);
            logger.info("Request headers: {}", headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );

            logger.info("Response status: {}", response.getStatusCode());
            logger.info("Response body: {}", response.getBody());

            return CompletableFuture.completedFuture(response.getBody());
        } catch (IOException e) {
            logger.error("Error processing image for emotion analysis", e);
            return CompletableFuture.failedFuture(e);
        } catch (Exception e) {
            logger.error("Error sending emotion request", e);
            return CompletableFuture.failedFuture(e);
        }
    }

    @Async
    public CompletableFuture<ResponseEntity<Resource>> sendTexture(TextureRequestDTO textureRequestDTO) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("userId", textureRequestDTO.getUserId());
            body.add("petMeshNumber", textureRequestDTO.getPetMeshNumber());
            body.add("image", new ByteArrayResource(textureRequestDTO.getImage().getBytes()) {
                @Override
                public String getFilename() {
                    return textureRequestDTO.getImage().getOriginalFilename();
                }
            });

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);


            ResponseEntity<byte[]> response = restTemplate.exchange(
                    AI_SERVICE_URL_2,
                    HttpMethod.POST,
                    requestEntity,
                    byte[].class
            );

            if (response.getHeaders().getContentType() == null ||
                    !response.getHeaders().getContentType().includes(MediaType.IMAGE_PNG)) {
                throw new RuntimeException("Received response is not a PNG file");
            }

            ByteArrayResource resource = new ByteArrayResource(response.getBody());

            return CompletableFuture.completedFuture(ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .contentLength(resource.contentLength())
                    .body(resource));
        } catch (IOException e) {
            return CompletableFuture.failedFuture(new RuntimeException("Error processing image", e));
        } catch (Exception e) {
            return CompletableFuture.failedFuture(new RuntimeException("Error sending texture request", e));
        }
    }
}