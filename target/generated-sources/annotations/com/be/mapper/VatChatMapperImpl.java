package com.be.mapper;

import com.be.common_api.VatChat;
import com.be.dto.VatChatDto;
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
public class VatChatMapperImpl implements VatChatMapper {

    @Override
    public VatChat toEntity(VatChatDto dto) {
        if ( dto == null ) {
            return null;
        }

        VatChat vatChat = new VatChat();

        vatChat.setId( dto.getId() );
        vatChat.setModifiedDate( dto.getModifiedDate() );
        vatChat.setCreatedDate( dto.getCreatedDate() );
        vatChat.setDeleted( dto.isDeleted() );

        return vatChat;
    }

    @Override
    public VatChatDto toDto(VatChat entity) {
        if ( entity == null ) {
            return null;
        }

        VatChatDto vatChatDto = new VatChatDto();

        vatChatDto.setId( entity.getId() );
        if ( entity.getModifiedDate() != null ) {
            vatChatDto.setModifiedDate( new Timestamp( entity.getModifiedDate().getTime() ) );
        }
        if ( entity.getCreatedDate() != null ) {
            vatChatDto.setCreatedDate( new Timestamp( entity.getCreatedDate().getTime() ) );
        }
        vatChatDto.setDeleted( entity.isDeleted() );

        return vatChatDto;
    }

    @Override
    public List<VatChat> toEntity(List<VatChatDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<VatChat> list = new ArrayList<VatChat>( dtoList.size() );
        for ( VatChatDto vatChatDto : dtoList ) {
            list.add( toEntity( vatChatDto ) );
        }

        return list;
    }

    @Override
    public List<VatChatDto> toDto(List<VatChat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VatChatDto> list = new ArrayList<VatChatDto>( entityList.size() );
        for ( VatChat vatChat : entityList ) {
            list.add( toDto( vatChat ) );
        }

        return list;
    }

    @Override
    public Set<VatChatDto> toDto(Set<VatChat> entityList) {
        if ( entityList == null ) {
            return null;
        }

        Set<VatChatDto> set = new LinkedHashSet<VatChatDto>( Math.max( (int) ( entityList.size() / .75f ) + 1, 16 ) );
        for ( VatChat vatChat : entityList ) {
            set.add( toDto( vatChat ) );
        }

        return set;
    }
}
