package com.be.mapper;

import com.be.common_api.Phong;
import com.be.dto.PhongDto;
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
public class PhongMapperImpl implements PhongMapper {

    @Override
    public Phong toEntity(PhongDto dto) {
        if ( dto == null ) {
            return null;
        }

        Phong phong = new Phong();

        phong.setId( dto.getId() );
        phong.setModifiedDate( dto.getModifiedDate() );
        phong.setCreatedDate( dto.getCreatedDate() );
        phong.setDeleted( dto.isDeleted() );
        phong.setIdNha( dto.getIdNha() );
        phong.setNha( dto.getNha() );
        phong.setName( dto.getName() );
        phong.setGia( dto.getGia() );
        phong.setStatus( dto.getStatus() );

        return phong;
    }

    @Override
    public PhongDto toDto(Phong entity) {
        if ( entity == null ) {
            return null;
        }

        PhongDto phongDto = new PhongDto();

        phongDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            phongDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            phongDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        phongDto.setDeleted( entity.isDeleted() );
        phongDto.setIdNha( entity.getIdNha() );
        phongDto.setNha( entity.getNha() );
        phongDto.setName( entity.getName() );
        phongDto.setGia( entity.getGia() );
        phongDto.setStatus( entity.getStatus() );

        return phongDto;
    }

    @Override
    public List<Phong> toEntity(List<PhongDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Phong> list = new ArrayList<Phong>( dtoList.size() );
        for ( PhongDto phongDto : dtoList ) {
            list.add( toEntity( phongDto ) );
        }

        return list;
    }

    @Override
    public List<PhongDto> toDto(List<Phong> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PhongDto> list = new ArrayList<PhongDto>( entityList.size() );
        for ( Phong phong : entityList ) {
            list.add( toDto( phong ) );
        }

        return list;
    }

    @Override
    public Set<PhongDto> toDto(Set<Phong> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<PhongDto> set = new LinkedHashSet<PhongDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Phong phong : entityList ) {
            set.add( toDto( phong ) );
        }

        return set;
    }
}
