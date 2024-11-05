package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.mapper.UserAuthMapper;
import com.jjh.mtvs.client.application.service.UserAuthService;
import com.jjh.mtvs.client.domain.model.user.entity.User;
import com.jjh.mtvs.client.domain.repository.UserRepository;
import com.jjh.mtvs.client.presentation.dto.response.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserRepository userRepository;
    private final UserAuthMapper userAuthMapper;

    @Override
    @Transactional
    public LoginResponseDto login(String email) {
        boolean isExistingUser = userRepository.existsByEmail(email);

        // 이메일로 사용자를 찾거나 새로 생성
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> createNewUser(email));

        // LoginResponseDto 생성 시 새로운 사용자 여부 설정
        LoginResponseDto response = userAuthMapper.toLoginResponseDto(user);
        response.setIsNewMember(!isExistingUser);

        return response;
    }

    private User createNewUser(String email) {
        User newUser = new User(email);
        return userRepository.save(newUser);
    }
}