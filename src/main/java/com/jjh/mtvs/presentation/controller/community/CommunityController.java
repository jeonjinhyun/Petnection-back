package com.jjh.mtvs.presentation.controller.community;

import com.jjh.mtvs.application.service.community.CommunityService;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/community")
@RequiredArgsConstructor
@Tag(name = "Community", description = "커뮤니티 API")
public class CommunityController {
    private final CommunityService communityService;

    @Operation(summary = "최신 커뮤니티 검색", description = "이름 또는 작성자로 최신 커뮤니티를 검색합니다.")
    @GetMapping("/search/recent/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> searchRecentRooms(
            @Parameter(description = "사용자 ID") @PathVariable Long userId,
            @Parameter(description = "검색어") @RequestParam String keyword,
            @PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(communityService.searchRecentRooms(userId, keyword, pageable));
    }

    @Operation(summary = "즐겨찾기 커뮤니티 검색", description = "이름 또는 작성자로 즐겨찾기한 커뮤니티를 검색합니다.")
    @GetMapping("/search/favorites/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> searchFavoriteRooms(
            @Parameter(description = "사용자 ID") @PathVariable Long userId,
            @Parameter(description = "검색어") @RequestParam String keyword,
            @PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(communityService.searchFavoriteRooms(userId, keyword, pageable));
    }

    @Operation(summary = "내 커뮤니티 검색", description = "이름 또는 작성자로 내가 만든 커뮤니티를 검색합니다.")
    @GetMapping("/search/my/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> searchMyRooms(
            @Parameter(description = "사용자 ID") @PathVariable Long userId,
            @Parameter(description = "검색어") @RequestParam String keyword,
            @PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(communityService.searchMyRooms(userId, keyword, pageable));
    }
} 