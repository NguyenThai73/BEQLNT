package com.be.mapper;

import com.be.common_api.Nha;
import com.be.dto.NhaDto;
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
public class NhaMapperImpl implements NhaMapper {

    @Override
    public Nha toEntity(NhaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Nha nha = new Nha();

        nha.setId( dto.getId() );
        nha.setModifiedDate( dto.getModifiedDate() );
        nha.setCreatedDate( dto.getCreatedDate() );
        nha.setDeleted( dto.isDeleted() );
        nha.setName( dto.getName() );
        nha.setAddress( dto.getAddress() );
        nha.setMoTa( dto.getMoTa() );
        nha.setStatus( dto.getStatus() );

        return nha;
    }

    @Override
    public NhaDto toDto(Nha entity) {
        if ( entity == null ) {
            return null;
        }

        NhaDto nhaDto = new NhaDto();

        nhaDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            nhaDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            nhaDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        nhaDto.setDeleted( entity.isDeleted() );
        nhaDto.setName( entity.getName() );
        nhaDto.setAddress( entity.getAddress() );
        nhaDto.setMoTa( entity.getMoTa() );
        nhaDto.setStatus( entity.getStatus() );

        return nhaDto;
    }

    @Override
    public List<Nha> toEntity(List<NhaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Nha> list = new ArrayList<Nha>( dtoList.size() );
        for ( NhaDto nhaDto : dtoList ) {
            list.add( toEntity( nhaDto ) );
        }

        return list;
    }

    @Override
    public List<NhaDto> toDto(List<Nha> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NhaDto> list = new ArrayList<NhaDto>( entityList.size() );
        for ( Nha nha : entityList ) {
            list.add( toDto( nha ) );
        }

        return list;
    }

    @Override
    public Set<NhaDto> toDto(Set<Nha> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<NhaDto> set = new LinkedHashSet<NhaDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( Nha nha : entityList ) {
            set.add( toDto( nha ) );
        }

        return set;
    }
}
