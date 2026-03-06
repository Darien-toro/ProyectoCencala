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
@RequestMapping("/api")
public class OrderStatusController {

    private final OrderStatusService orderStatusService;

    @GetMapping
    public List<OrderStatusDto> getALLOrderStatus(){
        return orderStatusService.getALLOrderStatu();
    }

    @GetMapping("/{id}")
    public OrderStatusDto getOrderStatusById(@PathVariable Integer id){
        return orderStatusService.getOrderStatusByYd(id);
    }

    @PostMapping
    public OrderStatusDto  createOrderStatusDto(@RequestBody OrderStatusDto dto){
        return orderStatusService.saveOrderStatu(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderStatus(@PathVariable Integer id){
        orderStatusService.deleteOrderStatu(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrderStatusDto> updateOrderStatus(@PathVariable Integer id, @RequestBody OrderStatusDto dto){
        OrderStatusDto update = orderStatusService.updateOrderStatus(id, dto);
        return ResponseEntity.ok(update);
    }
}
