package com.jjh.mtvs.app.presentation.controller.myroom;

import com.jjh.mtvs.app.application.service.MyRoomService;
import com.jjh.mtvs.app.presentation.dto.common.MyRoomDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/myroom")
@Tag(name = "My Room", description = "마이룸 관련 API")
@RequiredArgsConstructor
public class MyRoomController {
    private final MyRoomService myRoomService;

    @Operation(summary = "마이룸 조회", description = "사용자의 마이룸 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<MyRoomDto> getMyRoom(
            @Parameter(description = "사용자 ID", required = true)
            @PathVariable Long userId) {
        return ResponseEntity.ok(myRoomService.getMyRoom(userId));
    }

    @Operation(summary = "마이룸 업데이트", description = "마이룸 정보를 업데이트합니다.")
    @PutMapping
    public ResponseEntity<Boolean> updateMyRoom(
            @Parameter(description = "마이룸 정보", required = true)
            @RequestBody MyRoomDto dto) {
        return ResponseEntity.ok(myRoomService.updateMyRoom(dto));
    }
}