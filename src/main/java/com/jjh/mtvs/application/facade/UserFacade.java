package com.jjh.mtvs.application.facade;

import com.jjh.mtvs.application.mapper.PetMapper;
import com.jjh.mtvs.application.mapper.UserMapper;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.domain.model.user.entity.Pet;
import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.domain.model.user.entity.UserProfile;
import com.jjh.mtvs.domain.repository.user.UserRepository;
import com.jjh.mtvs.presentation.dto.request.auth.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFacade {

    private final UserMapper userMapper;
    private final PetMapper petMapper;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Transactional
    public Boolean join(SignupRequestDTO signupRequestDTO) {
        try {
            // 1. User 저장
            User user = userMapper.toUser(signupRequestDTO.getUserCreateRequestDTO());
            UserProfile userProfile = new UserProfile(
                    signupRequestDTO.getUserCreateRequestDTO().getName(),
                    fileUploadService.uploadFile(signupRequestDTO.getUserCreateRequestDTO().getImgFile())
                    );
            user.setProfile(userProfile);
            user = userRepository.save(user);

            // 2. Pet 생성 및 연결 
            Pet pet = petMapper.toPet(signupRequestDTO.getPetDto());
            user.setPet(pet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}