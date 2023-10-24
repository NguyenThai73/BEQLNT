package com.be.mapper;

import com.be.common_api.PhongVhatChat;
import com.be.dto.PhongVhatChatDto;
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
public class PhongVhatChatMapperImpl implements PhongVhatChatMapper {

    @Override
    public PhongVhatChat toEntity(PhongVhatChatDto dto) {
        if ( dto == null ) {
            return null;
        }

        PhongVhatChat phongVhatChat = new PhongVhatChat();

        phongVhatChat.setId( dto.getId() );
        phongVhatChat.setModifiedDate( dto.getModifiedDate() );
        phongVhatChat.setCreatedDate( dto.getCreatedDate() );
        phongVhatChat.setDeleted( dto.isDeleted() );
        phongVhatChat.setIdPhong( dto.getIdPhong() );
        phongVhatChat.setPhong( dto.getPhong() );
        phongVhatChat.setIdVatChat( dto.getIdVatChat() );
        phongVhatChat.setVatChat( dto.getVatChat() );
        phongVhatChat.setStatus( dto.getStatus() );

        return phongVhatChat;
    }

    @Override
    public PhongVhatChatDto toDto(PhongVhatChat entity) {
        if ( entity == null ) {
            return null;
        }

        PhongVhatChatDto phongVhatChatDto = new PhongVhatChatDto();

        phongVhatChatDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            phongVhatChatDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            phongVhatChatDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        phongVhatChatDto.setDeleted( entity.isDeleted() );
        phongVhatChatDto.setIdPhong( entity.getIdPhong() );
        phongVhatChatDto.setPhong( entity.getPhong() );
        phongVhatChatDto.setIdVatChat( entity.getIdVatChat() );
        phongVhatChatDto.setVatChat( entity.getVatChat() );
        phongVhatChatDto.setStatus( entity.getStatus() );

        return phongVhatChatDto;
    }

    @Override
    public List<PhongVhatChat> toEntity(List<PhongVhatChatDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PhongVhatChat> list = new ArrayList<PhongVhatChat>( dtoList.size() );
        for ( PhongVhatChatDto phongVhatChatDto : dtoList ) {
            list.add( toEntity( phongVhatChatDto ) );
        }

        return list;
    }

    @Override
    public List<PhongVhatChatDto> toDto(List<PhongVhatChat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PhongVhatChatDto> list = new ArrayList<PhongVhatChatDto>( entityList.size() );
        for ( PhongVhatChat phongVhatChat : entityList ) {
            list.add( toDto( phongVhatChat ) );
        }

        return list;
    }

    @Override
    public Set<PhongVhatChatDto> toDto(Set<PhongVhatChat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<PhongVhatChatDto> set = new LinkedHashSet<PhongVhatChatDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( PhongVhatChat phongVhatChat : entityList ) {
            set.add( toDto( phongVhatChat ) );
        }

        return set;
    }
}
