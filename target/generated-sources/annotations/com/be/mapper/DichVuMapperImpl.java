package com.be.mapper;

import com.be.common_api.DichVu;
import com.be.dto.DichVuDto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-21T11:39:20+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class DichVuMapperImpl implements DichVuMapper {

    @Override
    public DichVu toEntity(DichVuDto dto) {
        if ( dto == null ) {
            return null;
        }

        DichVu dichVu = new DichVu();

        dichVu.setId( dto.getId() );
        dichVu.setModifiedDate( dto.getModifiedDate() );
        dichVu.setCreatedDate( dto.getCreatedDate() );
        dichVu.setDeleted( dto.isDeleted() );
        dichVu.setIdNha( dto.getIdNha() );
        dichVu.setNha( dto.getNha() );
        dichVu.setDonVi( dto.getDonVi() );
        dichVu.setName( dto.getName() );
        dichVu.setDonGia( dto.getDonGia() );

        return dichVu;
    }

    @Override
    public DichVuDto toDto(DichVu entity) {
        if ( entity == null ) {
            return null;
        }

        DichVuDto dichVuDto = new DichVuDto();

        dichVuDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            dichVuDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            dichVuDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        dichVuDto.setDeleted( entity.isDeleted() );
        dichVuDto.setIdNha( entity.getIdNha() );
        dichVuDto.setNha( entity.getNha() );
        dichVuDto.setName( entity.getName() );
        dichVuDto.setDonVi( entity.getDonVi() );
        dichVuDto.setDonGia( entity.getDonGia() );

        return dichVuDto;
    }

    @Override
    public List<DichVu> toEntity(List<DichVuDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DichVu> list = new ArrayList<DichVu>( dtoList.size() );
        for ( DichVuDto dichVuDto : dtoList ) {
            list.add( toEntity( dichVuDto ) );
        }

        return list;
    }

    @Override
    public List<DichVuDto> toDto(List<DichVu> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DichVuDto> list = new ArrayList<DichVuDto>( entityList.size() );
        for ( DichVu dichVu : entityList ) {
            list.add( toDto( dichVu ) );
        }

        return list;
    }

    @Override
    public Set<DichVuDto> toDto(Set<DichVu> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<DichVuDto> set = new LinkedHashSet<DichVuDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( DichVu dichVu : entityList ) {
            set.add( toDto( dichVu ) );
        }

        return set;
    }
}
