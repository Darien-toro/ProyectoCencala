package com.project.springboot.cencala.lavandery.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.project.springboot.cencala.lavandery.dto.OrderRequestDto;
import com.project.springboot.cencala.lavandery.dto.OrderResponseDto;
import com.project.springboot.cencala.lavandery.dto.OrderWithItemsDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;
import com.project.springboot.cencala.lavandery.mapper.OrderMapper;
import com.project.springboot.cencala.lavandery.repository.CustomerRepository;
import com.project.springboot.cencala.lavandery.repository.OrderRepository;
import com.project.springboot.cencala.lavandery.repository.OrderStatusRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderStatusRepository orderStatusRepository;
    private final CustomerRepository customerRepository;

    public List<OrderResponseDto> getAllOrders(){
        return orderRepository.findAll()
        .stream()
        .map(orderMapper::toResponseDto)
        .toList();
    }

    public OrderResponseDto getOrderById(Integer id){
        OrderEntity entity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        return orderMapper.toResponseDto(entity);
    }

    public OrderResponseDto createOrderDto(OrderRequestDto dto){
        OrderEntity entity = orderMapper.toEntity(dto);

        if (dto.getCustomerId() != null) {
            entity.setOrderStatusEntity(orderStatusRepository.findById(dto.getOrderStatusId())
            .orElseThrow(() -> new RuntimeException("Estado no encontrado")));           
        }
        if(dto.getCustomerId() != null){
            entity.setCustomerEntity(customerRepository.findById(dto.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado")));
        }

        entity.setCode("PENDING");
        
        OrderEntity saved = orderRepository.save(entity);

        saved.setCode(String.format("OS-%d", saved.getId()));
        saved = orderRepository.save(saved);
        return orderMapper.toResponseDto(saved);
    }

        public void deleteOrder(Integer id){
        OrderEntity entity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        orderRepository.delete(entity);
    }

    public OrderResponseDto updateOrder(Integer id, OrderRequestDto dto){
        OrderEntity entity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        entity.setCode(dto.getCode());

        if(dto.getOrderStatusId() != null){
            entity.setOrderStatusEntity(orderStatusRepository.findById(dto.getOrderStatusId())
            .orElseThrow(() -> new RuntimeException("Estado no encontrada")));
        }
        if(dto.getCustomerId() != null) {
            entity.setCustomerEntity(customerRepository.findById(dto.getCustomerId())
        .orElseThrow(() -> new RuntimeException("Cliente no encontrada")));
        }
        OrderEntity update = orderRepository.save(entity);
        return orderMapper.toResponseDto(update);
    }
    
    public List<OrderWithItemsDto> getOrdersWithItemsByCustomerId(Integer customerId) {
        return orderRepository.findOrdersWithItemsByCustomerId(customerId);
    }
}