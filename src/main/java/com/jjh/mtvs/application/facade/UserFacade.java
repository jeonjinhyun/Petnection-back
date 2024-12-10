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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserFacade {

    private final UserMapper userMapper;
    private final PetMapper petMapper;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Transactional
    public Boolean join(SignupRequestDTO signupRequestDTO) {
        try {
            User user = userRepository.findById(signupRequestDTO.getUserCreateRequestDTO().getId())
                    .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

            UserProfile userProfile = new UserProfile(signupRequestDTO.getUserCreateRequestDTO().getName());
            if (signupRequestDTO.getUserCreateRequestDTO().getImgFile() != null) {
                userProfile.setImgUrl(fileUploadService.uploadFile(signupRequestDTO.getUserCreateRequestDTO().getImgFile()));
            }
            user.setProfile(userProfile);
            if (signupRequestDTO.getPetDto() != null) {
                Pet pet = petMapper.toPet(signupRequestDTO.getPetDto());

                pet.setId(user.getId());
                user.setPet(pet);
            }

            userRepository.save(user);

            return true;
        } catch (Exception e) {
            log.error("회원가입 중 오류 발생:", e);
            throw new RuntimeException("회원가입 실패: " + e.getMessage(), e);
        }
    }
}