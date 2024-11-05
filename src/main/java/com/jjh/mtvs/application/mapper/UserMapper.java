package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.presentation.dto.request.UserRequestDto;
import com.jjh.mtvs.presentation.dto.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "pet", ignore = true)
    @Mapping(target = "myRoom", ignore = true)
    @Mapping(target = "gallery", ignore = true)
    @Mapping(target = "imgUrl", ignore = true)
    @Mapping(target = "favorites", ignore = true)
    User toUser(UserRequestDto dto);

    UserResponseDto toUserResponseDto(User user);
}
