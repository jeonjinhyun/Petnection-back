package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.mapper.UserMapper;
import com.jjh.mtvs.client.application.service.UserQueryService;
import com.jjh.mtvs.client.domain.model.user.entity.User;
import com.jjh.mtvs.client.domain.repository.UserRepository;
import com.jjh.mtvs.client.presentation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto getUserInfo(Long userId) {
        User user = userRepository.findById(userId).get();
        return userMapper.toUserResponseDto(user);
    }
}
