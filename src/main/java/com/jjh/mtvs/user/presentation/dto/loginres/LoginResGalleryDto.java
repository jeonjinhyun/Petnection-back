package com.jjh.mtvs.user.presentation.dto.loginres;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class LoginResGalleryDto {
    private Long id;
    private String name;
    private List<MultipartFile> imgUrls;
}
