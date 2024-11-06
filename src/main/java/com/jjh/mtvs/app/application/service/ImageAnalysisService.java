package com.jjh.mtvs.app.application.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageAnalysisService {
    String analyzeImage(MultipartFile multipartFile);
}
