package com.be.mapper;

import com.be.common_api.HoaDon;
import com.be.dto.HoaDonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HoaDonMapper extends EntityMapper<HoaDonDto, HoaDon> {
}