package com.jjh.mtvs.application.serviceimpl.community;

import com.jjh.mtvs.application.mapper.CommentMappper;
import com.jjh.mtvs.application.service.community.CommentService;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.domain.model.community.entity.Comment;
import com.jjh.mtvs.domain.model.community.entity.Post;
import com.jjh.mtvs.domain.repository.community.CommentRepository;
import com.jjh.mtvs.domain.repository.community.PostRepository;
import com.jjh.mtvs.presentation.dto.request.community.CommentRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommentResponseDto;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentMappper commentMapper;
    private final UserQueryService userQueryService;

    @Override
    @Transactional
    public Long addComment(CommentRequestDTO dto) {
        try {
            Post post = postRepository.findById(dto.getPostId())
                    .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
            Comment comment = commentMapper.toComment(dto);
            UserProfileResponseDTO userProfile = userQueryService.getUserProfileResponseDTO(dto.getAuthor());
            comment.setAuthorId(dto.getAuthor());
            comment.setAuthorName(userProfile.getName());
            post.addComment(comment);  // 이미 잘 구현되어 있음
            return comment.getId();
        } catch (Exception e) {
            throw new RuntimeException("댓글 추가에 실패했습니다.", e);
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getComments(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        return post.getComments().stream()
                .map(comment -> {
                    CommentResponseDto dto = commentMapper.toCommentResponseDto(comment);
                    // 댓글 작성자의 프로필 정보 설정
                    UserProfileResponseDTO userProfile = userQueryService.getUserProfileResponseDTO(comment.getAuthorId());
                    dto.setUserProfileResponseDto(userProfile);
                    return dto;
                })
                .toList();
    }
    @Override
    @Transactional
    public Boolean deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
