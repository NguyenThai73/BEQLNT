package com.be.controller;

import com.be.common_api.HoaDon;
import com.be.common_api.HopDong;
import com.be.dto.HoaDonDto;
import com.be.dto.HopDongDto;
import com.be.mapper.HoaDonMapper;
import com.be.repository.HoaDonRepository;
import com.be.service.HoaDonService;
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

@RequestMapping("/api/hoa-don")
@RestController
@Slf4j
@Api("hoa-don")
public class HoaDonController {
    private final HoaDonService hoaDonService;
    private final HoaDonRepository repository;
    private final HoaDonMapper hoaDonMapper;

    public HoaDonController(HoaDonService hoaDonService, HoaDonRepository repository,HoaDonMapper hoaDonMapper) {
        this.hoaDonService = hoaDonService;
        this.repository = repository;
        this.hoaDonMapper = hoaDonMapper;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> save(@RequestBody @Validated HoaDon hoaDon) {
        try {
            repository.save(hoaDon);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            System.out.printf("======================="+e.getMessage()+"++++++++++++++++");
            return ResponseEntity.ok(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        try {
            hoaDonService.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<HoaDon> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<HoaDonDto> hoaDonPage = hoaDonService.findByCondition(spec, pageable);
            result.put("result", hoaDonPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Boolean> update(@RequestBody @Validated HoaDon hoaDon, @PathVariable("id") Long id) {
        try {
            hoaDon.setId(id);
            repository.save(hoaDon);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }
}