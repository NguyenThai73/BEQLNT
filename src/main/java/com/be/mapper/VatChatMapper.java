package com.be.mapper;

import com.be.common_api.VatChat;
import com.be.dto.VatChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VatChatMapper extends EntityMapper<VatChatDto, VatChat> {
}