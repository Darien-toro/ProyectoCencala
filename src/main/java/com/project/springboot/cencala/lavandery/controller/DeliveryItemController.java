package com.project.springboot.cencala.lavandery.controller;

import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.service.DeliveryItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery-item")
@AllArgsConstructor
public class DeliveryItemController {

    private final DeliveryItemService deliveryItemService;

    @GetMapping
    public ResponseEntity<List<DeliveryItemDto>> getAll() {
        return ResponseEntity.ok(deliveryItemService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryItemDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(deliveryItemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryItemDto> create(@RequestBody DeliveryItemDto dto) {
        DeliveryItemDto created = deliveryItemService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryItemDto> update(@PathVariable Integer id, @RequestBody DeliveryItemDto dto) {
        dto.setId(id);
        DeliveryItemDto updated = deliveryItemService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deliveryItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

