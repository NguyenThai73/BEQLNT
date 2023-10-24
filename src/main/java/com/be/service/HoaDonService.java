package com.be.service;

import com.be.common_api.HoaDon;
import com.be.dto.HoaDonDto;
import com.be.handler.Utils;
import com.be.mapper.HoaDonMapper;
import com.be.repository.HoaDonRepository;
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
public class HoaDonService {
    private final HoaDonRepository repository;
    private final HoaDonMapper hoaDonMapper;

    public HoaDonService(HoaDonRepository repository, HoaDonMapper hoaDonMapper) {
        this.repository = repository;
        this.hoaDonMapper = hoaDonMapper;
    }

    public HoaDonDto save(HoaDonDto hoaDonDto) {
        HoaDon entity = hoaDonMapper.toEntity(hoaDonDto);
        return hoaDonMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public HoaDonDto findById(Long id) {
        return hoaDonMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<HoaDonDto> findByCondition(@Filter Specification<HoaDon> spec, Pageable pageable) {
        Page<HoaDon> entityPage = repository.findAll(spec,pageable);
        List<HoaDon> entities = entityPage.getContent();
        return new PageImpl<>(hoaDonMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public HoaDonDto update(HoaDonDto hoaDonDto, Long id) {
        HoaDonDto data = findById(id);
        HoaDon entity = hoaDonMapper.toEntity(hoaDonDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(hoaDonMapper.toDto(entity));
    }
}