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

import com.project.springboot.cencala.lavandery.dto.DeliveryDto;
import com.project.springboot.cencala.lavandery.service.DeliveryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/delivery")
@AllArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<List<DeliveryDto>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> getDeliveryById(@PathVariable Integer id) {
        return ResponseEntity.ok(deliveryService.getDeliveryById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryDto> createDelivery(@RequestBody DeliveryDto dto) {
        return ResponseEntity.ok(deliveryService.createDelivery(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeliveryDto> updateDelivery(@PathVariable Integer id, @RequestBody DeliveryDto dto) {
        return ResponseEntity.ok(deliveryService.updateDelivery(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Integer id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
