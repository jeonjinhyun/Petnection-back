package com.jjh.mtvs.client.application.mapper;

import com.jjh.mtvs.client.domain.model.user.entity.User;
import com.jjh.mtvs.client.presentation.dto.response.LoginResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {

    @Mapping(target = "isNewMember", ignore = true)
    LoginResponseDto toLoginResponseDto(User user);
}
