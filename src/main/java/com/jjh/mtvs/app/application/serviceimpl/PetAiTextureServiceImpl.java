package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.service.PetAiTextureService;
import com.jjh.mtvs.app.presentation.dto.request.PetCreateDto;
import com.jjh.mtvs.common.util.file.FileUploadService;
import lombok.RequiredArgsConstructor;
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
public class PetAiTextureServiceImpl implements PetAiTextureService {

    private final RestTemplate restTemplate;
    private final FileUploadService fileUploadService;

    @Override
    @Async
    public CompletableFuture<String> createPetModel(PetCreateDto dto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("userId", dto.getId());
            body.add("petMeshNumber", dto.getPetMeshNumber());
            body.add("image", new ByteArrayResource(dto.getImgFile().getBytes()) {
                @Override
                public String getFilename() {
                    return dto.getImgFile().getOriginalFilename();
                }
            });

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            String AI_TEXTURE_SERVICE_URL = "https://sheepdog-bold-bulldog.ngrok-free.app/texture/img2texture";
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    AI_TEXTURE_SERVICE_URL,
                    HttpMethod.POST,
                    requestEntity,
                    byte[].class
            );

            if (response.getBody() == null) {
                throw new RuntimeException("No texture received from AI service");
            }

            // byte[]를 MultipartFile로 변환하고 파일 업로드 서비스를 통해 URL 받기
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
            return CompletableFuture.failedFuture(new RuntimeException("Error processing image", e));
        } catch (Exception e) {
            return CompletableFuture.failedFuture(new RuntimeException("Error creating pet model", e));
        }
    }
}
