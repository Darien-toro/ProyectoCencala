package com.project.springboot.cencala.lavandery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.DeliveryDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryEntity;
import com.project.springboot.cencala.lavandery.mapper.DeliveryMapper;
import com.project.springboot.cencala.lavandery.repository.DeliveryRepository;
import com.project.springboot.cencala.lavandery.repository.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;
    private final OrderRepository orderRepository;

    public List<DeliveryDto> getAllDeliveries() {
        return deliveryRepository.findAll()
                .stream()
                .map(deliveryMapper::toDto)
                .toList();
    }

    public DeliveryDto getDeliveryById(Integer id) {
        DeliveryEntity entity = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
        return deliveryMapper.toDto(entity);
    }

    public DeliveryDto createDelivery(DeliveryDto dto) {
        DeliveryEntity entity = deliveryMapper.toEntity(dto);

        if (dto.getOrder().getId() != null) {
            entity.setOrderEntity(orderRepository.findById(dto.getOrder().getId())
                    .orElseThrow(() -> new RuntimeException("Orden no encontrada")));
        }

        DeliveryEntity saved = deliveryRepository.save(entity);
        return deliveryMapper.toDto(saved);
    }

    public DeliveryDto updateDelivery(Integer id, DeliveryDto dto) {
        DeliveryEntity entity = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));

        if (dto.getOrder().getId() != null) {
            entity.setOrderEntity(orderRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("Orden no encontrada")));
        }

        DeliveryEntity updated = deliveryRepository.save(entity);
        return deliveryMapper.toDto(updated);
    }

    public void deleteDelivery(Integer id) {
        DeliveryEntity entity = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrega no encontrada"));
        deliveryRepository.delete(entity);
    }
}

