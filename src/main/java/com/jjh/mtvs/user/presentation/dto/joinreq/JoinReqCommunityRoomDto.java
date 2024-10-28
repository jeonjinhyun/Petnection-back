package com.jjh.mtvs.user.presentation.dto.joinreq;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class JoinReqCommunityRoomDto {
    private Long id;

    private String name;

    private MultipartFile imgFile;

    private Integer favoriteCount;

    private List<JoinReqCommunityRoomObjcetDto> joinReqCommunityRoomObjcetDtos;
}
