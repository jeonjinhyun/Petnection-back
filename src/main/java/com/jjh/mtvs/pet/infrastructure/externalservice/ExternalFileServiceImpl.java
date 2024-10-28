package com.jjh.mtvs.pet.infrastructure.externalservice;

import com.jjh.mtvs.common.file.MinioService;
import com.jjh.mtvs.pet.domain.infraservice.ExternalFileService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ExternalFileServiceImpl implements ExternalFileService {

    private final RestTemplate restTemplate;
    private final String fileUploadUrl = "http://localhost:9100/api/v1/files/upload";

    public ExternalFileServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 요청 바디 설정
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", multipartFile.getResource());

        // HTTP 엔티티 생성
        HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(body, headers);

        // FileController의 /upload 엔드포인트로 요청
        ResponseEntity<String> response = restTemplate.postForEntity(
                fileUploadUrl,
                requestEntity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("File upload failed: " + response.getBody());
        }
    }
}