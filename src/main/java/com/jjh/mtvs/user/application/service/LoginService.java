package com.jjh.mtvs.user.application.service;

import com.jjh.mtvs.user.domain.aggregate.entity.User;
import com.jjh.mtvs.user.domain.mapper.UserMapper;
import com.jjh.mtvs.user.domain.repository.UserRepository;
import com.jjh.mtvs.user.domain.service.ExternalCommunityRoomService;
import com.jjh.mtvs.user.domain.service.ExternalGalleryService;
import com.jjh.mtvs.user.domain.service.ExternalMyRoomService;
import com.jjh.mtvs.user.domain.service.ExternalPetService;
import com.jjh.mtvs.user.presentation.dto.UserDto;
import com.jjh.mtvs.user.presentation.dto.loginres.LoginResDto;
import com.jjh.mtvs.user.presentation.dto.loginres.LoginResUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LoginService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ExternalCommunityRoomService externalCommunityRoomService;
    private final ExternalGalleryService externalGalleryService;
    private final ExternalPetService externalPetService;
    private final ExternalMyRoomService externalMyRoomService;

    public LoginService(UserRepository userRepository, UserMapper userMapper,ExternalPetService externalPetService,ExternalMyRoomService externalMyRoomService,ExternalCommunityRoomService externalCommunityRoomService,ExternalGalleryService externalGalleryService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.externalPetService = externalPetService;
        this.externalMyRoomService = externalMyRoomService;
        this.externalCommunityRoomService = externalCommunityRoomService;
        this.externalGalleryService = externalGalleryService;
    }

    @Transactional
    public ResponseEntity<Object> loginUser(String userEmail) {
        // 이메일로 사용자 조회
        Optional<User> userOptional = userRepository.findByEmail(userEmail);

        if (userOptional.isPresent()) {
            // 기존 회원이면 LoginResDto 반환
            UserDto userDto= userMapper.toDto( userOptional.get());
            LoginResDto loginResDto = createLoginResDto(userDto);
            return ResponseEntity.ok(loginResDto);
        } else {
            // 새로운 회원이면 회원 생성 후 userId 반환
            User newUser = User.createNewUser(userEmail);
            User savedUser = userRepository.save(newUser);
            return ResponseEntity.ok(savedUser.getId());
        }
    }

    private LoginResDto createLoginResDto(UserDto userDto) {
        LoginResUserDto loginResUserDto = new LoginResUserDto(
                userDto.getId(),
                userDto.getName(),
                userDto.getImgUrl()
        );
        return new LoginResDto(
                loginResUserDto,
                externalPetService.getPetByUserId(userDto.getId()),
                externalMyRoomService.getMyRoomByUserId(userDto.getId()),
                externalCommunityRoomService.getCommunityRooms(),
                externalGalleryService.getGalleryByUserId(userDto.getId())
        );
    }
}