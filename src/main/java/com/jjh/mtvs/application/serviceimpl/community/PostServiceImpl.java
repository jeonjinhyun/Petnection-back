package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.mapper.PostMapper;
import com.jjh.mtvs.application.service.community.PostService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.community.entity.Post;
import com.jjh.mtvs.domain.model.user.entity.UserProfile;
import com.jjh.mtvs.domain.repository.community.CommunityRoomRepository;
import com.jjh.mtvs.domain.repository.community.PostRepository;
import com.jjh.mtvs.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.PostResponseDto;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
import com.jjh.mtvs.common.util.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final CommunityRoomRepository communityRoomRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final FileUploadService fileUploadService;
    private final UserQueryService userQueryService;

    @Override
    @Transactional
    public Boolean createPost(PostRequestDTO dto) {
        try {
            CommunityRoom communityRoom = communityRoomRepository.findById(dto.getCommunityRoomId())
                    .orElseThrow(() -> new RuntimeException("커뮤니티룸을 찾는데 실패했습니다."));
            Post post = postMapper.toPost(dto);
            UserProfileResponseDTO userProfile = userQueryService.getUserProfileResponseDTO(dto.getAuthor());
            post.setAuthorId(dto.getAuthor());
            post.setAuthorName(userProfile.getName());
            String imgUrl = fileUploadService.uploadFile(dto.getImgFile());
            post.setImgUrl(imgUrl);
            communityRoom.addPost(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponseDto> getPostsByCommunityRoomId(Long communityRoomId, Pageable pageable) {
        CommunityRoom communityRoom = communityRoomRepository.findById(communityRoomId)
                .orElseThrow(() -> new RuntimeException("커뮤니티룸을 찾을 수 없습니다."));

        // 커뮤니티 룸의 게시글을 Page 형태로 변환
        List<Post> posts = communityRoom.getPosts();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), posts.size());

        // 페이지 범위를 벗어나는 경우 빈 페이지 반환
        if (start > posts.size()) {
            return Page.empty(pageable);
        }

        List<Post> pageContent = posts.subList(start, end);
        Page<Post> postPage = new PageImpl<>(pageContent, pageable, posts.size());

        // Post를 PostResponseDto로 매핑
        return postPage.map(post -> {
            PostResponseDto dto = postMapper.toPostResponseDto(post);

            // 작성자의 프로필 정보를 가져와서 작성자 이름 설정
            try {
                UserProfileResponseDTO userInfo = userQueryService.getUserProfileResponseDTO(post.getAuthorId());
                dto.setAuthorName(userInfo.getName());
            } catch (Exception e) {
                // 프로필 정보를 가져오는 과정에서 예외가 발생하면 기본값 설정
                dto.setAuthorName("알 수 없는 사용자");
            }
            return dto;
        });
    }

    @Override
    @Transactional
    public Boolean deletePost(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}