package com.be.mapper;

import com.be.common_api.HoaDon;
import com.be.dto.HoaDonDto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-22T11:27:06+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class HoaDonMapperImpl implements HoaDonMapper {

    @Override
    public HoaDon toEntity(HoaDonDto dto) {
        if ( dto == null ) {
            return null;
        }

        HoaDon hoaDon = new HoaDon();

        hoaDon.setId( dto.getId() );
        hoaDon.setModifiedDate( dto.getModifiedDate() );
        hoaDon.setCreatedDate( dto.getCreatedDate() );
        hoaDon.setDeleted( dto.isDeleted() );
        hoaDon.setIdHopDong( dto.getIdHopDong() );
        hoaDon.setHopDong( dto.getHopDong() );
        hoaDon.setName( dto.getName() );
        hoaDon.setData( dto.getData() );
        hoaDon.setFile( dto.getFile() );
        hoaDon.setDueDate( dto.getDueDate() );
        hoaDon.setTotal( dto.getTotal() );
        hoaDon.setFine( dto.getFine() );
        hoaDon.setDescription( dto.getDescription() );
        hoaDon.setStatus( dto.getStatus() );

        return hoaDon;
    }

    @Override
    public HoaDonDto toDto(HoaDon entity) {
        if ( entity == null ) {
            return null;
        }

        HoaDonDto hoaDonDto = new HoaDonDto();

        hoaDonDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            hoaDonDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            hoaDonDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        hoaDonDto.setDeleted( entity.isDeleted() );
        hoaDonDto.setIdHopDong( entity.getIdHopDong() );
        hoaDonDto.setHopDong( entity.getHopDong() );
        hoaDonDto.setName( entity.getName() );
        hoaDonDto.setData( entity.getData() );
        hoaDonDto.setFile( entity.getFile() );
        hoaDonDto.setDueDate( entity.getDueDate() );
        hoaDonDto.setTotal( entity.getTotal() );
        hoaDonDto.setFine( entity.getFine() );
        hoaDonDto.setDescription( entity.getDescription() );
        hoaDonDto.setStatus( entity.getStatus() );

        return hoaDonDto;
    }

    @Override
    public List<HoaDon> toEntity(List<HoaDonDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HoaDon> list = new ArrayList<HoaDon>( dtoList.size() );
        for ( HoaDonDto hoaDonDto : dtoList ) {
            list.add( toEntity( hoaDonDto ) );
        }

        return list;
    }

    @Override
    public List<HoaDonDto> toDto(List<HoaDon> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HoaDonDto> list = new ArrayList<HoaDonDto>( entityList.size() );
        for ( HoaDon hoaDon : entityList ) {
            list.add( toDto( hoaDon ) );
        }

        return list;
    }

    @Override
    public Set<HoaDonDto> toDto(Set<HoaDon> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<HoaDonDto> set = new LinkedHashSet<HoaDonDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( HoaDon hoaDon : entityList ) {
            set.add( toDto( hoaDon ) );
        }

        return set;
    }
}
