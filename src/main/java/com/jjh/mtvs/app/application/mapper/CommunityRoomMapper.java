package com.jjh.mtvs.app.application.mapper;

import com.jjh.mtvs.app.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.app.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.CommunityResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityRoomMapper {
    CommunityRoom toCommunityRoom(CommunityRequestDTO dto);

    CommunityResponseDto toCommunityResponseDto(CommunityRoom communityRoom);
}
