package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.UserAuthMapper;
import com.jjh.mtvs.app.application.service.UserAuthService;
import com.jjh.mtvs.app.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.app.domain.model.user.entity.Pet;
import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.domain.repository.UserRepository;
import com.jjh.mtvs.app.presentation.dto.response.LoginResponseDto;
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

        // User 생성만 하면 연관 엔티티들은 자동 생성됨
        User user = userRepository.findByEmail(email)
                .orElseGet(() -> userRepository.save(new User(email)));

        LoginResponseDto response = userAuthMapper.toLoginResponseDto(user);
        response.setIsNewMember(!isExistingUser);

        return response;
    }
}