package com.project.springboot.cencala.lavandery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.OrderStatusDto;
import com.project.springboot.cencala.lavandery.entity.OrderStatusEntity;
import com.project.springboot.cencala.lavandery.mapper.OrderStatusMapper;
import com.project.springboot.cencala.lavandery.repository.OrderStatusRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    private final OrderStatusMapper orderStatusMapper;

    public List<OrderStatusDto> getALLOrderStatu(){
        return orderStatusRepository.findAll().stream()
            .map(orderStatusMapper::toDTO)
            .collect(Collectors.toList());
    }

    public OrderStatusDto getOrderStatusByYd(Integer id){
        return orderStatusRepository.findById(id)
        .map(orderStatusMapper::toDTO)
        .orElse(null);
    }

    public OrderStatusDto saveOrderStatu(OrderStatusDto dto){
        OrderStatusEntity savedEntity = orderStatusRepository.save(orderStatusMapper.toEntity(dto));
        return orderStatusMapper.toDTO(savedEntity);
    }

    public void deleteOrderStatu(Integer id){
        orderStatusRepository.deleteById(id);
    }

    public OrderStatusDto updateOrderStatus(Integer id, OrderStatusDto dto){
        OrderStatusEntity entity = orderStatusRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));

        orderStatusMapper.updateEntityFromDto(dto, entity);

        OrderStatusEntity update = orderStatusRepository.save(entity);
        return orderStatusMapper.toDTO(update);
    }
}
