package com.jjh.mtvs.presentation.controller.user;

import com.jjh.mtvs.application.service.user.UserAuthService;
import com.jjh.mtvs.presentation.dto.request.auth.LoginRequestDTO;
import com.jjh.mtvs.presentation.dto.response.auth.LoginResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "인증 관련 API")
public class UserAuthController {

    private final UserAuthService userAuthService;

    @Operation(summary = "로그인", description = "이메일을 통한 로그인을 수행합니다.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Parameter(description = "사용자 이메일", required = true)
            @RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDto = userAuthService.login(loginRequestDTO);
        return ResponseEntity.ok(loginResponseDto);
    }
}
