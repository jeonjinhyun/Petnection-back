package com.jjh.mtvs.pet.domain.infraservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExternalFileService {
    String uploadFile(MultipartFile multipartFile) throws Exception;
}