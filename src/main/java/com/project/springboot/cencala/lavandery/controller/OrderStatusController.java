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

import com.project.springboot.cencala.lavandery.dto.OrderStatusDto;
import com.project.springboot.cencala.lavandery.service.OrderStatusService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order-status")
public class OrderStatusController {

    private final OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatusDto> findAll(){
        return orderStatusService.findAll();
    }

    @GetMapping("/{id}")
    public OrderStatusDto findById(@PathVariable Integer id){
        return orderStatusService.findById(id);
    }

    @PostMapping
    public OrderStatusDto save(@RequestBody OrderStatusDto dto){
        return orderStatusService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        orderStatusService.delete(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusDto> update(@PathVariable Integer id, @RequestBody OrderStatusDto dto){
        OrderStatusDto update = orderStatusService.update(id, dto);
        return ResponseEntity.ok(update);
    }
}
