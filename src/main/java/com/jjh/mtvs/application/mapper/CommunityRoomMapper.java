package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = ObjectMapper.class)
public interface CommunityRoomMapper {
    @Mapping(target = "objectDtos", source = "objects")
    CommunityResponseDto toCommunityResponseDto(CommunityRoom communityRoom);

    @Mapping(target = "objects", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    CommunityRoom toCommunityRoom(CommunityRequestDTO dto);
}