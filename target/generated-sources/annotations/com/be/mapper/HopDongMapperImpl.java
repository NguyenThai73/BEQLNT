package com.be.mapper;

import com.be.common_api.HopDong;
import com.be.dto.HopDongDto;
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
public class HopDongMapperImpl implements HopDongMapper {

    @Override
    public HopDong toEntity(HopDongDto dto) {
        if ( dto == null ) {
            return null;
        }

        HopDong hopDong = new HopDong();

        hopDong.setId( dto.getId() );
        hopDong.setModifiedDate( dto.getModifiedDate() );
        hopDong.setCreatedDate( dto.getCreatedDate() );
        hopDong.setDeleted( dto.isDeleted() );
        hopDong.setIdPhong( dto.getIdPhong() );
        hopDong.setPhong( dto.getPhong() );
        hopDong.setDateStart( dto.getDateStart() );
        hopDong.setDateEnd( dto.getDateEnd() );
        hopDong.setFile( dto.getFile() );
        hopDong.setNumberPeople( dto.getNumberPeople() );
        hopDong.setStatus( dto.getStatus() );

        return hopDong;
    }

    @Override
    public HopDongDto toDto(HopDong entity) {
        if ( entity == null ) {
            return null;
        }

        HopDongDto hopDongDto = new HopDongDto();

        hopDongDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            hopDongDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            hopDongDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        hopDongDto.setDeleted( entity.isDeleted() );
        hopDongDto.setIdPhong( entity.getIdPhong() );
        hopDongDto.setPhong( entity.getPhong() );
        hopDongDto.setDateStart( entity.getDateStart() );
        hopDongDto.setDateEnd( entity.getDateEnd() );
        hopDongDto.setFile( entity.getFile() );
        hopDongDto.setNumberPeople( entity.getNumberPeople() );
        hopDongDto.setStatus( entity.getStatus() );

        return hopDongDto;
    }

    @Override
    public List<HopDong> toEntity(List<HopDongDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HopDong> list = new ArrayList<HopDong>( dtoList.size() );
        for ( HopDongDto hopDongDto : dtoList ) {
            list.add( toEntity( hopDongDto ) );
        }

        return list;
    }

    @Override
    public List<HopDongDto> toDto(List<HopDong> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HopDongDto> list = new ArrayList<HopDongDto>( entityList.size() );
        for ( HopDong hopDong : entityList ) {
            list.add( toDto( hopDong ) );
        }

        return list;
    }

    @Override
    public Set<HopDongDto> toDto(Set<HopDong> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<HopDongDto> set = new LinkedHashSet<HopDongDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( HopDong hopDong : entityList ) {
            set.add( toDto( hopDong ) );
        }

        return set;
    }
}
