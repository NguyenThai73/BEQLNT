package com.be.controller;

import com.be.common_api.DichVu;
import com.be.dto.DichVuDto;
import com.be.mapper.DichVuMapper;
import com.be.repository.DichVuRepository;
import com.be.service.DichVuService;
import com.llq.springfilter.boot.Filter;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/dich-vu")
@RestController
@Slf4j
@Api("dich-vu")
public class DichVuController {
    private final DichVuService dichVuService;
    private final DichVuRepository repository;

    public DichVuController(DichVuRepository repository,DichVuService dichVuService) {
        this.repository = repository;
        this.dichVuService = dichVuService;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> save(@RequestBody @Validated DichVuDto dichVuDto) {
        try {
            dichVuService.save(dichVuDto);
            return ResponseEntity.ok(true);
        }
        catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }
    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            dichVuService.deleteById(id);
            return ResponseEntity.ok(true);
        }
        catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<DichVu> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 1000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<DichVuDto> dichVuPage = dichVuService.findByCondition(spec, pageable);
            result.put("result", dichVuPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated DichVu dichVu, @PathVariable("id") Long id) {
        dichVu.setId(id);
        repository.save(dichVu);
        return ResponseEntity.ok().build();
    }
}