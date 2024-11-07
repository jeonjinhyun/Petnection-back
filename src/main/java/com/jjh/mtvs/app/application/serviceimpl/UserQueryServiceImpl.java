package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.mapper.UserMapper;
import com.jjh.mtvs.app.application.service.MyRoomService;
import com.jjh.mtvs.app.application.service.PetService;
import com.jjh.mtvs.app.application.service.UserQueryService;
import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.domain.repository.UserRepository;
import com.jjh.mtvs.app.presentation.dto.common.UserDto;
import com.jjh.mtvs.app.presentation.dto.response.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MyRoomService myRoomService;
    private final PetService petService;

    @Override
    public UserResponseDto getUserResponseDto(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("유저를 찾는데 실패했습니다."));
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public UserDto getUserDto(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("유저를 찾는데 실패했습니다."));
        UserDto response = userMapper.toUserDto(user);
        response.setMyRoomDto(myRoomService.getMyRoom(userId));
        response.setPetResponseDto(petService.getPetDto(userId));
        return response;
    }

    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("사용자를 찾는데 실패했습니다."));
    }
}
