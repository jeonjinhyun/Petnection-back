package com.jjh.mtvs.app.presentation.controller;

import com.jjh.mtvs.app.application.service.UserAuthService;
import com.jjh.mtvs.app.presentation.dto.response.LoginResponseDto;
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
    public ResponseEntity<LoginResponseDto> login(
            @Parameter(description = "사용자 이메일", required = true)
            @RequestBody String email) {
        LoginResponseDto loginResponseDto = userAuthService.login(email);
        return ResponseEntity.ok(loginResponseDto);
    }
}
