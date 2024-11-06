package com.jjh.mtvs.app.presentation.dto.request;

import com.jjh.mtvs.app.presentation.dto.ObjectDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data
@Schema(description = "커뮤니티 요청 DTO")
public class CommunityRequestDto {
    @Schema(description = "커뮤니티 이름", example = "우리 동네 모임")
    private String name;

    @Schema(description = "커뮤니티 이미지", type = "file")
    private MultipartFile imgFile;

    @Schema(description = "오브젝트 목록")
    private List<ObjectDto> objectDtos;
}
