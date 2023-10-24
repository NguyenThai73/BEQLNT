package com.be.service;

import com.be.common_api.Nha;
import com.be.dto.NhaDto;
import com.be.handler.Utils;
import com.be.mapper.NhaMapper;
import com.be.repository.NhaRepository;
import com.llq.springfilter.boot.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class NhaService {
    private final NhaRepository repository;
    private final NhaMapper nhaMapper;

    public NhaService(NhaRepository repository, NhaMapper nhaMapper) {
        this.repository = repository;
        this.nhaMapper = nhaMapper;
    }

    public NhaDto save(NhaDto nhaDto) {
        Nha entity = nhaMapper.toEntity(nhaDto);
        return nhaMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public NhaDto findById(Long id) {
        return nhaMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }
    public Page<Nha> findByCondition(@Filter Specification<Nha> spec, Pageable pageable) {
        Page<Nha> entityPage = repository.findAll(spec, pageable);
        List<Nha> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public NhaDto update(NhaDto nhaDto, Long id) {
        NhaDto data = findById(id);
        Nha entity = nhaMapper.toEntity(nhaDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(nhaMapper.toDto(entity));
    }
}