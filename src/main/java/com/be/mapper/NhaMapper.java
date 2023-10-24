package com.be.mapper;

import com.be.common_api.Nha;
import com.be.dto.NhaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NhaMapper extends EntityMapper<NhaDto, Nha> {
}