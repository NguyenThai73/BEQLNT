package com.be.controller;

import com.be.common_api.HopDong;
import com.be.dto.HopDongDto;
import com.be.dto.PhongDto;
import com.be.mapper.HopDongMapper;
import com.be.repository.HopDongRepository;
import com.be.service.HopDongService;
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

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/hop-dong")
@RestController
@Slf4j
@Api("hop-dong")
public class HopDongController {
    private final HopDongRepository repository;
    private final HopDongService hopDongService;
    private final HopDongMapper hopDongMapper;

    public HopDongController(HopDongService hopDongService, HopDongRepository repository, HopDongMapper hopDongMapper) {
        this.hopDongService = hopDongService;
        this.repository = repository;
        this.hopDongMapper = hopDongMapper;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> save(@RequestBody @Validated HopDong hopDong) {
       try {
           repository.save(hopDong);
           return ResponseEntity.ok(true);
       }catch (Exception e){
           return ResponseEntity.ok(false);
       }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            HopDongDto hopDongDto =  hopDongService.findById(id);
            HopDong hopDong = hopDongMapper.toEntity(hopDongDto);
            hopDong.setDeleted(true);
            repository.save(hopDong);
            return ResponseEntity.ok(true);
        }catch (Exception e){
        }
        return ResponseEntity.ok(false);
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<HopDong> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<HopDongDto> hopDongPage = hopDongService.findByCondition(spec, pageable);
            result.put("result", hopDongPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Boolean> update(@RequestBody @Validated HopDong hopDong, @PathVariable("id") Long id) {
        try {
            hopDong.setId(id);
            repository.save(hopDong);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
}