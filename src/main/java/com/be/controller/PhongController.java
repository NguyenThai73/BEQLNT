package com.be.controller;

import com.be.common_api.Phong;
import com.be.common_api.VatChat;
import com.be.dto.PhongDto;
import com.be.mapper.PhongMapper;
import com.be.service.PhongService;
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

@RequestMapping("/api/phong")
@RestController
@Slf4j
@Api("phong")
public class PhongController {
    private final PhongService phongService;

    public PhongController(PhongService phongService) {
        this.phongService = phongService;
    }

    @PostMapping("/post")
    public ResponseEntity<Long> save(@RequestBody @Validated PhongDto phongDto) {
       try {
           PhongDto item= phongService.save(phongDto);
           return ResponseEntity.ok(item.getId());
       }catch (Exception e){
           Long abc = 0L;
           return ResponseEntity.ok(abc);
       }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
       try {
           phongService.deleteById(id);
           return ResponseEntity.ok(true);
       }catch (Exception e){
           return ResponseEntity.ok(false);
       }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<Phong> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 1000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<PhongDto> phongPage = phongService.findByCondition(spec, pageable);
            result.put("result", phongPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PhongDto phongDto, @PathVariable("id") Long id) {
        phongDto.setId(id);
        phongService.update(phongDto, id);
        return ResponseEntity.ok().build();
    }
}