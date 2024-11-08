package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.presentation.dto.request.user.UserCreateRequestDTO;
import com.jjh.mtvs.presentation.dto.response.user.UserProfileResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "pet", ignore = true)
    @Mapping(target = "myRoom", ignore = true)
    @Mapping(target = "gallery", ignore = true)
    @Mapping(target = "profile", ignore = true)
    User toUser(UserCreateRequestDTO dto);

    UserProfileResponseDTO toUserResponseDto(User user);
}
