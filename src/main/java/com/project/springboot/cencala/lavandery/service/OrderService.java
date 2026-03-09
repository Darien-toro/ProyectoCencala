package com.project.springboot.cencala.lavandery.service;

import java.util.List;

import com.project.springboot.cencala.lavandery.mapper.CustomerMapper;
import com.project.springboot.cencala.lavandery.mapper.OrderStatusMapper;
import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.OrderDto;
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
    private final OrderStatusMapper orderStatusMapper;
    private final CustomerMapper customerMapper;

    public List<OrderDto> findAll(){
        return orderRepository.findAll()
        .stream()
        .map(orderMapper::toDto)
        .toList();
    }

    public OrderDto findById(Integer id){
        OrderEntity entity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        return orderMapper.toDto(entity);
    }

    public OrderDto save(OrderDto dto){
        OrderEntity entity = orderMapper.toEntity(dto);

        if (dto.getOrderStatus().getId() != null) {
            entity.setOrderStatusEntity(orderStatusRepository.findById(dto.getOrderStatus().getId())
            .orElseThrow(() -> new RuntimeException("Estado no encontrado")));
            dto.setOrderStatus(orderStatusMapper.toDTO(entity.getOrderStatusEntity()));
        }
        if(dto.getCustomer().getId() != null){
            entity.setCustomerEntity(customerRepository.findById(dto.getCustomer().getId())
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado")));
            dto.setCustomer(customerMapper.toDTO(entity.getCustomerEntity()));
        }

        dto.setCode("PENDING");
        
        OrderEntity saved = orderRepository.save(orderMapper.toEntity(dto));

        saved.setCode(String.format("OS-%d", saved.getId()));
        saved = orderRepository.save(saved);
        return orderMapper.toDto(saved);
    }

    public OrderDto update(Integer id, OrderDto dto){
        OrderEntity entity = orderRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        entity.setCode(dto.getCode());

        if(dto.getOrderStatus().getId() != null){
            entity.setOrderStatusEntity(orderStatusRepository.findById(dto.getOrderStatus().getId())
            .orElseThrow(() -> new RuntimeException("Estado no encontrada")));
            dto.setOrderStatus(orderStatusMapper.toDTO(entity.getOrderStatusEntity()));
        }
        if(dto.getCustomer().getId() != null) {
            entity.setCustomerEntity(customerRepository.findById(dto.getCustomer().getId())
        .orElseThrow(() -> new RuntimeException("Cliente no encontrada")));
            dto.setCustomer(customerMapper.toDTO(entity.getCustomerEntity()));
        }
        OrderEntity update = orderRepository.save(orderMapper.toEntity(dto));
        return orderMapper.toDto(update);
    }

    public void delete(Integer id){
        OrderEntity entity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrado"));
        orderRepository.delete(entity);
    }

    public List<OrderWithItemsDto> getOrdersWithItemsByCustomerId(Integer customerId) {
        return orderRepository.findOrdersWithItemsByCustomerId(customerId);
    }
}