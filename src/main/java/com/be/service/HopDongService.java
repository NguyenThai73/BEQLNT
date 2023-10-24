package com.be.service;

import com.be.common_api.HopDong;
import com.be.dto.HopDongDto;
import com.be.handler.Utils;
import com.be.mapper.HopDongMapper;
import com.be.repository.HopDongRepository;
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
public class HopDongService {
    private final HopDongRepository repository;
    private final HopDongMapper hopDongMapper;

    public HopDongService(HopDongRepository repository, HopDongMapper hopDongMapper) {
        this.repository = repository;
        this.hopDongMapper = hopDongMapper;
    }

    public HopDongDto save(HopDongDto hopDongDto) {
        HopDong entity = hopDongMapper.toEntity(hopDongDto);
        return hopDongMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HopDongDto findById(Long id) {
        return hopDongMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<HopDongDto> findByCondition(@Filter Specification<HopDong> spec, Pageable pageable) {
        Page<HopDong> entityPage = repository.findAll(spec, pageable);
        List<HopDong> entities = entityPage.getContent();
        return new PageImpl<>(hopDongMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HopDongDto update(HopDongDto hopDongDto, Long id) {
        HopDongDto data = findById(id);
        HopDong entity = hopDongMapper.toEntity(hopDongDto);
        BeanUtils.copyProperties(data, entity, Utils.getNullPropertyNames(entity));
        return save(hopDongMapper.toDto(entity));
    }
}