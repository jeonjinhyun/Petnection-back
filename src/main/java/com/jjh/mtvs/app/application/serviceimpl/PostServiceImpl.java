package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.PostMapper;
import com.jjh.mtvs.app.application.service.PostService;
import com.jjh.mtvs.app.application.service.UserQueryService;
import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.domain.model.community.entity.Post;
import com.jjh.mtvs.app.domain.repository.CommunityRoomRepository;
import com.jjh.mtvs.app.domain.repository.PostRepository;
import com.jjh.mtvs.app.presentation.dto.request.PostRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.PostResponseDto;
import com.jjh.mtvs.app.presentation.dto.response.UserResponseDto;
import com.jjh.mtvs.common.util.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final CommunityRoomRepository communityRoomRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final FileUploadService fileUploadService;
    private final UserQueryService userQueryService;

    @Override
    public Boolean createPost(PostRequestDto dto) {
        try{
            CommunityRoom communityRoom = communityRoomRepository.findById(dto.getCommunityRoomId())
                    .orElseThrow(()->new RuntimeException("커뮤니티룸을 찾는데 실패했습니다."));
            Post post = postMapper.toPost(dto);
            String imgUrl = fileUploadService.uploadFile(dto.getImgFile());
            post.setImgUrl(imgUrl);
            communityRoom.addPost(post);
            communityRoomRepository.save(communityRoom);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PostResponseDto> getPostsByCommunityRoomId(Long communityRoomId, Pageable pageable) {
        try {
            Page<Post> postPage = postRepository.findByCommunityRoomId(communityRoomId, pageable);

            return postPage.map(post -> {
                PostResponseDto dto = postMapper.toPostResponseDto(post);
                // authorId로 사용자 정보 조회하여 이름 설정
                UserResponseDto userInfo = userQueryService.getUserResponseDto(post.getAuthorId());
                dto.setAuthorName(userInfo.getName());
                return dto;
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to get posts", e);
        }
    }

    @Override
    public Boolean deletePost(Long id) {
        try{
            postRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
