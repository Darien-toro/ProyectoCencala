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
@RequestMapping("/api/product-lines")
@AllArgsConstructor
public class ProductLineController {

    private final ProductLineService productLineService;

    @GetMapping
    public ResponseEntity<List<ProductLineDto>> getAllProductLines() {
        return ResponseEntity.ok(productLineService.getAllProductLines());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductLineDto> getProductLineById(@PathVariable Integer id) {
        return ResponseEntity.ok(productLineService.getProductLineById(id));
    }

    @PostMapping
    public ResponseEntity<ProductLineDto> createProductLine(@RequestBody ProductLineDto dto) {
        return ResponseEntity.ok(productLineService.createProductLine(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductLineDto> updateProductLine(@PathVariable Integer id, @RequestBody ProductLineDto dto) {
        return ResponseEntity.ok(productLineService.updateProductLine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductLine(@PathVariable Integer id) {
        productLineService.deleteProductLine(id);
        return ResponseEntity.noContent().build();
    }
}

