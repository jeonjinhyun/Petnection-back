package com.jjh.mtvs.app.presentation.controller;
import com.jjh.mtvs.app.application.facade.JoinFacadeService;
import com.jjh.mtvs.app.application.service.UserQueryService;
import com.jjh.mtvs.app.presentation.dto.request.JoinUserDto;
import com.jjh.mtvs.app.presentation.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "사용자 관련 API")
public class UserController {

    private final UserQueryService userQueryService;
    private final JoinFacadeService joinFacadeService;

    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping(value = "/join",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> join(@ModelAttribute JoinUserDto joinUserDto) {
        return ResponseEntity.ok(joinFacadeService.join(joinUserDto));
    }

    @Operation(summary = "사용자 정보 조회", description = "사용자 ID로 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(userQueryService.getUserResponseDto(userId));
    }
}
