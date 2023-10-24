package com.be.service;

import com.be.common_api.Phong;
import com.be.dto.PhongDto;
import com.be.handler.Utils;
import com.be.mapper.PhongMapper;
import com.be.repository.PhongRepository;
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
public class PhongService {
    private final PhongRepository repository;
    private final PhongMapper phongMapper;

    public PhongService(PhongRepository repository, PhongMapper phongMapper) {
        this.repository = repository;
        this.phongMapper = phongMapper;
    }

    public PhongDto save(PhongDto phongDto) {
        Phong entity = phongMapper.toEntity(phongDto);
        return phongMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public PhongDto findById(Long id) {
        return phongMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<PhongDto> findByCondition(@Filter Specification<Phong> spec, Pageable pageable) {
        Page<Phong> entityPage = repository.findAll(spec, pageable);
        List<Phong> entities = entityPage.getContent();
        return new PageImpl<>(phongMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PhongDto update(PhongDto phongDto, Long id) {
        PhongDto data = findById(id);
        Phong entity = phongMapper.toEntity(phongDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(phongMapper.toDto(entity));
    }
}