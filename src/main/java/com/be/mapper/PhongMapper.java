package com.be.mapper;

import com.be.common_api.Phong;
import com.be.dto.PhongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhongMapper extends EntityMapper<PhongDto, Phong> {
}