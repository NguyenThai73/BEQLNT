package com.be.service;

import com.be.common_api.Nha;
import com.be.common_api.VatChat;
import com.be.dto.NhaDto;
import com.be.dto.VatChatDto;
import com.be.handler.Utils;
import com.be.mapper.VatChatMapper;
import com.be.repository.VatChatRepository;
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
public class VatChatService {
    private final VatChatRepository repository;
    private final VatChatMapper vatChatMapper;

    public VatChatService(VatChatRepository repository, VatChatMapper vatChatMapper) {
        this.repository = repository;
        this.vatChatMapper = vatChatMapper;
    }

    public VatChatDto save(VatChatDto vatChatDto) {
        VatChat entity = vatChatMapper.toEntity(vatChatDto);
        return vatChatMapper.toDto(repository.save(entity));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public VatChatDto findById(Long id) {
        return vatChatMapper.toDto(repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Item Not Found! ID: " + id)
        ));
    }

    public Page<VatChat> findByCondition(@Filter Specification<VatChat> spec, Pageable pageable) {
        Page<VatChat> entityPage = repository.findAll(spec, pageable);
        List<VatChat> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    public VatChatDto update(VatChatDto vatChatDto, Long id) {
        VatChatDto data = findById(id);
        VatChat entity = vatChatMapper.toEntity(vatChatDto);
        BeanUtils.copyProperties(entity, data, Utils.getNullPropertyNames(entity));
        return save(vatChatMapper.toDto(entity));
    }
}