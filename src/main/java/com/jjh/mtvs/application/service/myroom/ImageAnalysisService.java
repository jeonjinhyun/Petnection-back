package com.jjh.mtvs.application.service.myroom;

import org.springframework.web.multipart.MultipartFile;

public interface ImageAnalysisService {
    String analyzeImage(MultipartFile multipartFile,Long userId);
}
