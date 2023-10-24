package com.be.mapper;

import com.be.common_api.DichVu;
import com.be.dto.DichVuDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DichVuMapper extends EntityMapper<DichVuDto, DichVu> {
}