package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.service.user.PetAiTextureService;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.presentation.dto.request.user.PetTextureCreateRequestDTO;
import com.jjh.mtvs.presentation.dto.response.user.FurAnalysisResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j  // 로깅 추가
public class PetAiTextureServiceImpl implements PetAiTextureService {

    private final RestTemplate restTemplate;
    private final FileUploadService fileUploadService;

    private final String aiServiceUrl = "http://221.163.19.142:55508/chatbot/index_of_fur_color";

    @Override
    @Async
    public CompletableFuture<String> createPetModel(PetTextureCreateRequestDTO dto) {
        try {
            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            // 요청 바디 구성 - AIService와 동일한 방식으로
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            // String으로 변환하여 보내기
            body.add("userId", String.valueOf(dto.getId()));
            body.add("petMeshNumber", String.valueOf(dto.getPetMeshNumber()));
            body.add("image", new ByteArrayResource(dto.getImgFile().getBytes()) {
                @Override
                public String getFilename() {
                    return dto.getImgFile().getOriginalFilename();
                }

                @Override
                public String getDescription() {
                    return "Pet image file";
                }
            });

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            // 로깅 추가
            log.info("Sending request to AI service");
            log.info("Request body: {}", body);


            String AI_TEXTURE_SERVICE_URL = "https://sheepdog-bold-bulldog.ngrok-free.app/texture/img2texture";
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    AI_TEXTURE_SERVICE_URL,
                    HttpMethod.POST,
                    requestEntity,
                    byte[].class
            );

            // 응답 로깅
            log.info("Response status: {}", response.getStatusCode());
            log.info("Response content type: {}", response.getHeaders().getContentType());

            if (response.getBody() == null) {
                throw new RuntimeException("No texture received from AI service");
            }

            // PNG 파일 타입 확인
            if (response.getHeaders().getContentType() == null ||
                    !response.getHeaders().getContentType().includes(MediaType.IMAGE_PNG)) {
                throw new RuntimeException("Received response is not a PNG file");
            }

            String fileName = "texture_" + dto.getId() + "_" + System.currentTimeMillis() + ".png";
            MultipartFile textureFile = new MockMultipartFile(
                    fileName,
                    fileName,
                    MediaType.IMAGE_PNG_VALUE,
                    response.getBody()
            );

            String textureUrl = fileUploadService.uploadFile(textureFile);
            return CompletableFuture.completedFuture(textureUrl);

        } catch (IOException e) {
            log.error("Error processing image: ", e);
            return CompletableFuture.failedFuture(new RuntimeException("Error processing image", e));
        } catch (Exception e) {
            log.error("Error creating pet model: ", e);
            return CompletableFuture.failedFuture(new RuntimeException("Error creating pet model", e));
        }
    }

    @Override
    public FurAnalysisResponseDTO analyzeFurColor(MultipartFile image) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("image", image.getResource());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            log.info("Sending request to AI service for fur analysis");
            ResponseEntity<FurAnalysisResponseDTO> response = restTemplate.exchange(
                    aiServiceUrl,
                    HttpMethod.POST,
                    requestEntity,
                    FurAnalysisResponseDTO.class
            );

            log.info("Received response from AI service: {}", response.getBody());
            return response.getBody();

        } catch (Exception e) {
            log.error("Error analyzing fur color:", e);
            throw new RuntimeException("Failed to analyze fur color", e);
        }
    }
}