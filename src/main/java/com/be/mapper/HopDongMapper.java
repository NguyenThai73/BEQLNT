package com.be.mapper;

import com.be.common_api.HopDong;
import com.be.dto.HopDongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HopDongMapper extends EntityMapper<HopDongDto, HopDong> {
}