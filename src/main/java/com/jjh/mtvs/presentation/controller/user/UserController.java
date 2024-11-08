package com.jjh.mtvs.presentation.controller.user;
import com.jjh.mtvs.application.facade.UserFacade;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.presentation.dto.request.auth.SignupRequestDTO;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
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
    private final UserFacade userFacade;

    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping(value = "/join",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> join(@ModelAttribute SignupRequestDTO signupRequestDTO) {
        return ResponseEntity.ok(userFacade.join(signupRequestDTO));
    }

    @Operation(summary = "사용자 프로필 정보 조회", description = "사용자 ID로 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileResponseDTO> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(userQueryService.getUserProfileResponseDTO(userId));
    }

}
