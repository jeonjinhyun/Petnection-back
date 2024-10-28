package com.jjh.mtvs.common.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    String uploadFile(MultipartFile file) throws Exception;
}
