package com.jjh.mtvs.client.application.serviceimpl;

import com.jjh.mtvs.client.application.facade.JoinFacadeService;
import com.jjh.mtvs.client.application.mapper.PetMapper;
import com.jjh.mtvs.client.application.mapper.UserMapper;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.client.domain.model.user.entity.Pet;
import com.jjh.mtvs.client.domain.model.user.entity.User;
import com.jjh.mtvs.client.domain.repository.UserRepository;
import com.jjh.mtvs.client.presentation.dto.request.JoinUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinFacadeServiceImpl implements JoinFacadeService {

    private final UserMapper userMapper;
    private final PetMapper petMapper;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Override
    @Transactional
    public Boolean join(JoinUserDto joinUserDto) {
        try {
            // 1. User 저장
            User user = userMapper.toUser(joinUserDto.getUserRequestDto());
            user.setImgUrl(fileUploadService.uploadFile(joinUserDto.getUserRequestDto().getImgFile()));
            user = userRepository.save(user);

            // 2. Pet 생성 및 연결 
            Pet pet = petMapper.toPet(joinUserDto.getPetRequestDto());
            // User의 ID가 Pet의 ID가 됨 (@MapsId)
            pet.setUser(user);
            user.setPet(pet);  // 양방향 관계 설정

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}