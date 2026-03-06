package com.project.springboot.cencala.lavandery.controller;

import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.dto.DeliveryItemRequestDto;
import com.project.springboot.cencala.lavandery.service.DeliveryItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-items")
@AllArgsConstructor
public class DeliveryItemController {

    private final DeliveryItemService deliveryItemService;

    @GetMapping
    public ResponseEntity<List<DeliveryItemDto>> getAllDeliveryItems() {
        return ResponseEntity.ok(deliveryItemService.getAllDeliveryItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryItemDto> getDeliveryItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(deliveryItemService.getDeliveryItemById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryItemDto> createDeliveryItem(@RequestBody DeliveryItemRequestDto dto) {
        DeliveryItemDto created = deliveryItemService.createDeliveryItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryItemDto> updateDeliveryItem(@PathVariable Integer id,
                                                              @RequestBody DeliveryItemRequestDto dto) {
        DeliveryItemDto updated = deliveryItemService.updateDeliveryItem(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliveryItem(@PathVariable Integer id) {
        deliveryItemService.deleteDeliveryItem(id);
        return ResponseEntity.noContent().build();
    }
}

