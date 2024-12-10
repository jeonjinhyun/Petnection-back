package com.jjh.mtvs.application.serviceimpl.user;

import com.jjh.mtvs.application.mapper.UserAuthMapper;
import com.jjh.mtvs.application.service.common.MetricsService;
import com.jjh.mtvs.application.service.user.UserAuthService;
import com.jjh.mtvs.domain.model.myroom.entity.Gallery;
import com.jjh.mtvs.domain.model.myroom.entity.MyRoom;
import com.jjh.mtvs.domain.model.user.entity.Pet;
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
    private final MetricsService metricsService;

    @Override
    @Transactional
    public LoginResponseDTO login(LoginRequestDTO dto) {
        boolean isExistingUser = userRepository.existsByEmail(dto.getEmail());

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseGet(() -> createNewUser(dto.getEmail()));

        LoginResponseDTO response = userAuthMapper.toLoginResponseDto(user);
        response.setIsNewMember(!isExistingUser);

        if(!isExistingUser) {
            metricsService.incrementSignupCounter();
        }

        return response;
    }

    private User createNewUser(String email) {
        User user = new User(email);

        // 1. User를 먼저 저장하여 ID 생성
        user = userRepository.save(user);
        Long userId = user.getId();

        // 2. 연관 엔티티들 생성 및 설정
        Pet pet = new Pet();
        pet.setId(userId);
        user.setPet(pet);

        MyRoom myRoom = new MyRoom();
        myRoom.setId(userId);
        user.setMyRoom(myRoom);

        Gallery gallery = new Gallery();
        gallery.setId(userId);
        user.setGallery(gallery);

        // 3. 최종 저장
        return userRepository.save(user);
    }
}