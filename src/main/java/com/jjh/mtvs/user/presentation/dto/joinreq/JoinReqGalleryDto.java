package com.jjh.mtvs.user.presentation.dto.joinreq;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class JoinReqGalleryDto {
    private Long id;
    private String name;
    private List<MultipartFile> imgFiles;
}
