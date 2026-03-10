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
import com.project.springboot.cencala.lavandery.dto.OrderDto;
import com.project.springboot.cencala.lavandery.dto.OrderWithItemsDto;
import com.project.springboot.cencala.lavandery.service.OrderService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto dto) {
        return ResponseEntity.ok(orderService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> update(@PathVariable Integer id, @RequestBody OrderDto dto) {
        dto.setId(id);
        return ResponseEntity.ok(orderService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/with-items/by-customer/{customerId}")
    public List<OrderWithItemsDto> getOrdersWithItemsByCustomerId(@PathVariable Integer customerId) {
        return orderService.getOrdersWithItemsByCustomerId(customerId);
    }
}