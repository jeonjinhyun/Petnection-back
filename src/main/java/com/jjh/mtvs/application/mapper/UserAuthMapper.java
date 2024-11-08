package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.user.entity.User;
import com.jjh.mtvs.presentation.dto.request.auth.LoginRequestDTO;
import com.jjh.mtvs.presentation.dto.response.auth.LoginResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAuthMapper {

    @Mapping(target = "isNewMember", ignore = true)
    LoginResponseDTO toLoginResponseDto(User user);

}
