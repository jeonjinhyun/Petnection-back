package com.jjh.mtvs.pet.infrastructure.externalservice;

import com.jjh.mtvs.pet.domain.infraservice.ExternalAiService;
import com.jjh.mtvs.pet.presentation.dto.AITextureResDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AITextureClientImpl implements ExternalAiService {
    private final RestTemplate restTemplate;
    private final String aiServerUrl = "https://sheepdog-bold-bulldog.ngrok-free.app/texture/img2texture";

    public AITextureClientImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AITextureResDto getTexture(MultipartFile imageFile) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", imageFile.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<AITextureResDto> response = restTemplate.postForEntity(
                aiServerUrl,
                requestEntity,
                AITextureResDto.class
        );

        return response.getBody();
    }
}