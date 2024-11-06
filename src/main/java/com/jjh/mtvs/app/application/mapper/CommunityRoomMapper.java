package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.presentation.dto.request.CommunityRequestDto;
import com.jjh.mtvs.app.presentation.dto.response.CommunityResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityRoomMapper {
    CommunityRoom toCommunityRoom(CommunityRequestDto dto);

    CommunityResponseDto toCommunityResponseDto(CommunityRoom communityRoom);
}
