package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.mapper.UserAuthMapper;
import com.jjh.mtvs.application.service.user.UserAuthService;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.request.auth.LoginRequestDTO;
import com.jjh.mtvs.presentation.dto.response.auth.LoginResponseDTO;
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
    public LoginResponseDTO login(LoginRequestDTO dto) {
        boolean isExistingUser = userRepository.existsByEmail(dto.getEmail());

        // User 생성만 하면 연관 엔티티들은 자동 생성됨
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseGet(() -> userRepository.save(new User(dto.getEmail())));

        LoginResponseDTO response = userAuthMapper.toLoginResponseDto(user);
        response.setIsNewMember(!isExistingUser);

        return response;
    }
}