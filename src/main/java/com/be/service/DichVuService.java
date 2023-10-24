package com.be.service;

import com.be.common_api.DichVu;
import com.be.dto.DichVuDto;
import com.be.handler.Utils;
import com.be.mapper.DichVuMapper;
import com.be.repository.DichVuRepository;
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
public class DichVuService {
    private final DichVuRepository repository;
    private final DichVuMapper dichVuMapper;

    public DichVuService(DichVuRepository repository, DichVuMapper dichVuMapper) {
        this.repository = repository;
        this.dichVuMapper = dichVuMapper;
    }

    public DichVuDto save(DichVuDto dichVuDto) {
        DichVu entity = dichVuMapper.toEntity(dichVuDto);
        return dichVuMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DichVuDto findById(Long id) {
        return dichVuMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<DichVuDto> findByCondition(@Filter Specification<DichVu> spec, Pageable pageable) {
        Page<DichVu> entityPage = repository.findAll(spec,pageable);
        List<DichVu> entities = entityPage.getContent();
        return new PageImpl<>(dichVuMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public DichVuDto update(DichVuDto dichVuDto, Long id) {
        DichVuDto data = findById(id);
        DichVu entity = dichVuMapper.toEntity(dichVuDto);
        BeanUtils.copyProperties(data, entity, Utils.getNullPropertyNames(entity));
        return save(dichVuMapper.toDto(entity));
    }
}