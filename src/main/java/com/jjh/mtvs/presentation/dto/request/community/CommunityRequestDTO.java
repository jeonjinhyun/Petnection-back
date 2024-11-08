package com.jjh.mtvs.presentation.dto.request.community;

import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
@Schema(description = "커뮤니티 요청 DTO")
public class CommunityRequestDTO {
    @Schema(description = "커뮤니티 이름", example = "우리 동네 모임")
    private String name;

    @Schema(description = "이미지 파일", type = "string", format = "binary")
    private MultipartFile imgFile;

    @Schema(description = "오브젝트 목록")
    private List<ObjectDto> objectDtos;
}
