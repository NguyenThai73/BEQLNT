package com.be.mapper;

import com.be.common_api.PhongVhatChat;
import com.be.dto.PhongVhatChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhongVhatChatMapper extends EntityMapper<PhongVhatChatDto, PhongVhatChat> {
}