package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.mapper.UserMapper;
import com.jjh.mtvs.application.service.user.UserQueryService;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserProfileResponseDTO getUserProfileResponseDTO(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("유저를 찾는데 실패했습니다."));
        return userMapper.toUserResponseDto(user);
    }


    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("사용자를 찾는데 실패했습니다."));
    }
}
