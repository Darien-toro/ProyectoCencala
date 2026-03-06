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

    public List<OrderStatusDto> findAll(){
        return orderStatusRepository.findAll().stream()
            .map(orderStatusMapper::toDTO)
            .collect(Collectors.toList());
    }

    public OrderStatusDto findById(Integer id){
        return orderStatusRepository.findById(id)
        .map(orderStatusMapper::toDTO)
        .orElse(null);
    }

    public OrderStatusDto save(OrderStatusDto dto){
        OrderStatusEntity savedEntity = orderStatusRepository.save(orderStatusMapper.toEntity(dto));
        return orderStatusMapper.toDTO(savedEntity);
    }

    public void delete(Integer id){
        orderStatusRepository.deleteById(id);
    }

    public OrderStatusDto update(Integer id, OrderStatusDto dto){
        OrderStatusEntity entity = orderStatusRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));
        OrderStatusEntity update = orderStatusRepository.save(orderStatusMapper.toEntity(dto));
        return orderStatusMapper.toDTO(update);
    }
}
