package com.be.service;

import com.be.common_api.PhongVhatChat;
import com.be.dto.PhongVhatChatDto;
import com.be.handler.Utils;
import com.be.mapper.PhongVhatChatMapper;
import com.be.repository.PhongVhatChatRepository;
import com.llq.springfilter.boot.Filter;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PhongVhatChatService {
    private final PhongVhatChatRepository repository;
    private final PhongVhatChatMapper phongVhatChatMapper;

    public PhongVhatChatService(PhongVhatChatRepository repository, PhongVhatChatMapper phongVhatChatMapper) {
        this.repository = repository;
        this.phongVhatChatMapper = phongVhatChatMapper;
    }

    public PhongVhatChatDto save(PhongVhatChatDto phongVhatChatDto) {
        PhongVhatChat entity = phongVhatChatMapper.toEntity(phongVhatChatDto);
        return phongVhatChatMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public PhongVhatChatDto findById(Long id) {
        return phongVhatChatMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }


    public Page<PhongVhatChatDto> findByCondition(@Filter Specification<PhongVhatChat> spec, Pageable pageable) {
        Page<PhongVhatChat> entityPage = repository.findAll(spec, pageable);
        List<PhongVhatChat> entities = entityPage.getContent();
        return new PageImpl<>(phongVhatChatMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PhongVhatChatDto update(PhongVhatChatDto phongVhatChatDto, Long id) {
        PhongVhatChatDto data = findById(id);
        PhongVhatChat entity = phongVhatChatMapper.toEntity(phongVhatChatDto);
        BeanUtils.copyProperties(data, entity, Utils.getNullPropertyNames(entity));
        return save(phongVhatChatMapper.toDto(entity));
    }
}