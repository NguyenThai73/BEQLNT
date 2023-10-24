package com.be.controller;

import com.be.common_api.PhongVhatChat;
import com.be.dto.PhongDto;
import com.be.dto.PhongVhatChatDto;
import com.be.mapper.PhongVhatChatMapper;
import com.be.repository.PhongVhatChatRepository;
import com.be.service.PhongVhatChatService;
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

@RequestMapping("/api/phong-vat-chat")
@RestController
@Slf4j
@Api("phong-vhat-chat")
public class PhongVhatChatController {
    private final PhongVhatChatService phongVhatChatService;
    private final PhongVhatChatRepository repository;

    public PhongVhatChatController(PhongVhatChatService phongVhatChatService, PhongVhatChatRepository repository) {
        this.phongVhatChatService = phongVhatChatService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Boolean> save(@RequestBody @Validated PhongVhatChat phongVhatChat) {
       try {
           repository.save(phongVhatChat);
           return ResponseEntity.ok(true);
       }catch (Exception e){
           return ResponseEntity.ok(false);
       }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
       try {
           phongVhatChatService.deleteById(id);
           return ResponseEntity.ok(true);
       }catch (Exception e){
           return ResponseEntity.ok(false);
       }
    }

    @GetMapping("/get/page")
    public ResponseEntity< Map<String, Object>> pageQuery(@Filter Specification<PhongVhatChat> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 1000) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<PhongVhatChatDto> phongVhatChatPage = phongVhatChatService.findByCondition(spec, pageable);
            result.put("result", phongVhatChatPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Boolean> update(@RequestBody @Validated PhongVhatChat phongVhatChat, @PathVariable("id") Long id) {
        try {
            phongVhatChat.setId(id);
            repository.save(phongVhatChat);
            return ResponseEntity.ok(true);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }
}