package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.presentation.dto.response.LoginResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {

    @Mapping(target = "isNewMember", ignore = true)
    LoginResponseDto toLoginResponseDto(User user);
}
