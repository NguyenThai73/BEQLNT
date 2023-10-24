package com.be.controller;

import com.be.common_api.Nha;
import com.be.dto.NhaDto;
import com.be.repository.NhaRepository;
import com.be.service.NhaService;
import com.llq.springfilter.boot.Filter;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/nha")
@RestController
@Slf4j
@Api("nha")
public class NhaController {
    private final NhaService nhaService;
    private final NhaRepository repository;
    public NhaController(NhaService nhaService,NhaRepository repository) {
        this.nhaService = nhaService;this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated Nha nha) {
        Map<String, Object> result = new HashMap<>();
        try{

            Nha item=repository.save(nha);
            result.put("result", item.getId());
            result.put("success",true);
        }
        catch (Exception e){
            System.out.printf("==========="+e.getMessage()+"===========");
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
        nhaService.deleteById(id);
        try {
            nhaService.deleteById(id);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<Nha> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 1000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<Nha> nhaPage = nhaService.findByCondition(spec, pageable);
            result.put("result", nhaPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated Nha nha, @PathVariable("id") Long id) {
        nha.setId(id);
        repository.save(nha);
        return ResponseEntity.ok().build();
    }
}