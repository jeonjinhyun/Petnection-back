package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.community.entity.CommunityRoom;
import com.jjh.mtvs.domain.model.object.entity.Object;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",uses = ObjectMapper.class)
public interface CommunityRoomMapper {

    @Mapping(target = "objectDtos",source = "objects")
    CommunityResponseDto toCommunityResponseDto(CommunityRoom communityRoom);

    @Mapping(target = "objects", source = "objectDtos")
    CommunityRoom toCommunityRoom(CommunityRequestDTO dto);

    @AfterMapping
    default void setCommunityRoomReference(@MappingTarget CommunityRoom communityRoom, CommunityRequestDTO dto) {
        if (dto.getObjectDtos() != null) {
            dto.getObjectDtos().stream()
                    .map(this::toObject)
                    .forEach(communityRoom::addCommunityObject);
        }
    }

    Object toObject(ObjectDto objectDto);
}
