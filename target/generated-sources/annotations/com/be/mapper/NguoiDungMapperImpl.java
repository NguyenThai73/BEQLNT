package com.be.mapper;

import com.be.common_api.NguoiDung;
import com.be.dto.NguoiDungDto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T21:52:20+0700",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.18 (Oracle Corporation)"
)
@Component
public class NguoiDungMapperImpl implements NguoiDungMapper {

    @Override
    public NguoiDung toEntity(NguoiDungDto dto) {
        if ( dto == null ) {
            return null;
        }

        NguoiDung nguoiDung = new NguoiDung();

        nguoiDung.setModifiedDate( dto.getModifiedDate() );
        nguoiDung.setCreatedDate( dto.getCreatedDate() );
        nguoiDung.setDeleted( dto.isDeleted() );
        nguoiDung.setId( dto.getId() );
        nguoiDung.setIdHopDong( dto.getIdHopDong() );
        nguoiDung.setHopDong( dto.getHopDong() );
        nguoiDung.setUsername( dto.getUsername() );
        nguoiDung.setPassword( dto.getPassword() );
        nguoiDung.setRole( dto.getRole() );
        nguoiDung.setFullName( dto.getFullName() );
        nguoiDung.setNamSinh( dto.getNamSinh() );
        nguoiDung.setSdt( dto.getSdt() );
        nguoiDung.setAvatar( dto.getAvatar() );
        nguoiDung.setFileCccd( dto.getFileCccd() );
        nguoiDung.setStatus( dto.getStatus() );

        return nguoiDung;
    }

    @Override
    public NguoiDungDto toDto(NguoiDung entity) {
        if ( entity == null ) {
            return null;
        }

        NguoiDungDto nguoiDungDto = new NguoiDungDto();

        nguoiDungDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            nguoiDungDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            nguoiDungDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        nguoiDungDto.setDeleted( entity.isDeleted() );
        nguoiDungDto.setIdHopDong( entity.getIdHopDong() );
        nguoiDungDto.setHopDong( entity.getHopDong() );
        nguoiDungDto.setUsername( entity.getUsername() );
        nguoiDungDto.setPassword( entity.getPassword() );
        nguoiDungDto.setRole( entity.getRole() );
        nguoiDungDto.setFullName( entity.getFullName() );
        nguoiDungDto.setNamSinh( entity.getNamSinh() );
        nguoiDungDto.setSdt( entity.getSdt() );
        nguoiDungDto.setAvatar( entity.getAvatar() );
        nguoiDungDto.setFileCccd( entity.getFileCccd() );
        nguoiDungDto.setStatus( entity.getStatus() );

        return nguoiDungDto;
    }

    @Override
    public List<NguoiDung> toEntity(List<NguoiDungDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<NguoiDung> list = new ArrayList<NguoiDung>( dtoList.size() );
        for ( NguoiDungDto nguoiDungDto : dtoList ) {
            list.add( toEntity( nguoiDungDto ) );
        }

        return list;
    }

    @Override
    public List<NguoiDungDto> toDto(List<NguoiDung> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NguoiDungDto> list = new ArrayList<NguoiDungDto>( entityList.size() );
        for ( NguoiDung nguoiDung : entityList ) {
            list.add( toDto( nguoiDung ) );
        }

        return list;
    }

    @Override
    public Set<NguoiDungDto> toDto(Set<NguoiDung> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<NguoiDungDto> set = new LinkedHashSet<NguoiDungDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( NguoiDung nguoiDung : entityList ) {
            set.add( toDto( nguoiDung ) );
        }

        return set;
    }
}
