package com.jjh.mtvs.app.presentation.controller;

import com.jjh.mtvs.app.application.service.CommunityFavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/favorite")
@Tag(name = "Community Favorite", description = "커뮤니티 즐겨찾기 관련 API")
@RequiredArgsConstructor
public class CommunityFavoriteController {
    private final CommunityFavoriteService communityFavoriteService;

    @Operation(summary = "즐겨찾기 추가", description = "커뮤니티를 즐겨찾기에 추가합니다.")
    @PostMapping("/{userId}/{mapId}")
    public ResponseEntity<Boolean> addFavorite(
            @Parameter(description = "사용자 ID", required = true) @PathVariable Long userId,
            @Parameter(description = "맵 ID", required = true) @PathVariable Long mapId) {
        return ResponseEntity.ok(communityFavoriteService.addFavorite(userId, mapId));
    }

    @Operation(summary = "즐겨찾기 제거", description = "커뮤니티를 즐겨찾기에서 제거합니다.")
    @DeleteMapping("/{userId}/{mapId}")
    public ResponseEntity<Boolean> removeFavorite(
            @Parameter(description = "사용자 ID", required = true) @PathVariable Long userId,
            @Parameter(description = "맵 ID", required = true) @PathVariable Long mapId) {
        return ResponseEntity.ok(communityFavoriteService.removeFavorite(userId, mapId));
    }
}
