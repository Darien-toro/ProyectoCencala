package com.project.springboot.cencala.lavandery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.cencala.lavandery.dto.ProductLineDto;
import com.project.springboot.cencala.lavandery.service.ProductLineService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product-line")
@AllArgsConstructor
public class ProductLineController {

    private final ProductLineService productLineService;

    @GetMapping
    public ResponseEntity<List<ProductLineDto>> findAll() {
        return ResponseEntity.ok(productLineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductLineDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productLineService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductLineDto> save(@RequestBody ProductLineDto dto) {
        return ResponseEntity.ok(productLineService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductLineDto> update(@PathVariable Integer id, @RequestBody ProductLineDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(productLineService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productLineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

