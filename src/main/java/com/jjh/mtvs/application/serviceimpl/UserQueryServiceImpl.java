package com.jjh.mtvs.application.serviceimpl;

import com.jjh.mtvs.application.mapper.UserAuthMapper;
import com.jjh.mtvs.application.mapper.UserMapper;
import com.jjh.mtvs.application.service.UserQueryService;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.UserRepository;
import com.jjh.mtvs.presentation.dto.response.UserResponseDto;
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
