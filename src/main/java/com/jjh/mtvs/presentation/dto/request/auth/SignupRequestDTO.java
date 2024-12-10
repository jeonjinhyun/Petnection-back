package com.jjh.mtvs.presentation.dto.request.auth;

import com.jjh.mtvs.presentation.dto.common.PetDTO;
import com.jjh.mtvs.presentation.dto.request.user.UserCreateRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(description = "회원가입 사용자 DTO")
public class SignupRequestDTO {
    @Schema(description = "사용자 요청 정보")
    private UserCreateRequestDTO userCreateRequestDTO;

    @Schema(description = "반려동물 요청 정보")
    private PetDTO petDto;


}