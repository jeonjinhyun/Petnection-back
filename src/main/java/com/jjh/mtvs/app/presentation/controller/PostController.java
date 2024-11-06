package com.jjh.mtvs.app.presentation.controller;

import com.jjh.mtvs.app.application.service.PostService;
import com.jjh.mtvs.app.presentation.dto.request.PostRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.PostResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @Operation(summary = "게시글 작성", description = "새로운 게시글을 작성합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> createPost(
            @ModelAttribute PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.createPost(postRequestDto));
    }


    @Operation(summary = "게시글 목록 조회", description = "커뮤니티의 게시글 목록을 조회합니다.")
    @GetMapping("/{communityRoomId}")
    public ResponseEntity<Page<PostResponseDto>> getPosts(
            @PathVariable Long communityRoomId,
            @PageableDefault(page = 0, size = 5, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(postService.getPostsByCommunityRoomId(communityRoomId, pageable));
    }

    @Operation(summary = "게시글 삭제", description = "커뮤니티의 게시글을 삭제합니다")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id){
        if(postService.deletePost(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }
}
