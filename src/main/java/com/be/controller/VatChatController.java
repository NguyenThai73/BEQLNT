package com.be.controller;

import com.be.common_api.Nha;
import com.be.common_api.VatChat;
import com.be.dto.VatChatDto;
import com.be.mapper.VatChatMapper;
import com.be.repository.VatChatRepository;
import com.be.service.VatChatService;
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

@RequestMapping("/api/vat-chat")
@RestController
@Slf4j
@Api("vat-chat")
public class VatChatController {
    private final VatChatService vatChatService;
    private final VatChatRepository repository;
    public VatChatController(VatChatService vatChatService,VatChatRepository repository) {
        this.vatChatService = vatChatService;
        this.repository = repository;
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Validated VatChat vatChat) {
        Map<String, Object> result = new HashMap<>();
        try{

            VatChat item=repository.save(vatChat);
            result.put("result", item.getId());
            result.put("success",true);
        }
        catch (Exception e){
            result.put("result",e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {
      try {
          vatChatService.deleteById(id);
          return ResponseEntity.ok(true);
      }catch (Exception e){
          return ResponseEntity.ok(false);
      }
    }

    @GetMapping("/get/page")
    public ResponseEntity<Map<String, Object>> pageQuery(@Filter Specification<VatChat> spec, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            Page<VatChat> vatChatPage = vatChatService.findByCondition(spec, pageable);
            result.put("result", vatChatPage);
            result.put("success",true);
        } catch (Exception e) {
            result.put("result", e.getMessage());
            result.put("success",false);
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated VatChat vatChat, @PathVariable("id") Long id) {
        vatChat.setId(id);
        repository.save(vatChat);
        return ResponseEntity.ok().build();
    }
}