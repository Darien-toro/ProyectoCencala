package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.dto.DeliveryItemRequestDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;
import com.project.springboot.cencala.lavandery.mapper.DeliveryItemMapper;
import com.project.springboot.cencala.lavandery.repository.DeliveryItemRepository;
import com.project.springboot.cencala.lavandery.repository.ProductRepository;
import com.project.springboot.cencala.lavandery.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryItemService {

    private final DeliveryItemRepository deliveryItemRepository;
    private final DeliveryItemMapper deliveryItemMapper;
    private final ProductRepository productRepository;
    private final DeliveryRepository deliveryRepository;

    public List<DeliveryItemDto> getAllDeliveryItems() {
        return deliveryItemRepository.findAll()
                .stream()
                .map(deliveryItemMapper::toDto)
                .toList();
    }

    public DeliveryItemDto getDeliveryItemById(Integer id) {
        DeliveryItemEntity entity = deliveryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));
        return deliveryItemMapper.toDto(entity);
    }

    public DeliveryItemDto createDeliveryItem(DeliveryItemRequestDto dto) {
        DeliveryItemEntity entity = deliveryItemMapper.toEntity(dto);

        if (dto.getProductId() != null) {
            entity.setProductEntity(productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        }

        if (dto.getDelivery().getId() != null) {
            entity.setDeliveryEntity(deliveryRepository.findById(dto.getDelivery().getId())
                    .orElseThrow(() -> new RuntimeException("Delivery no encontrado")));
        }

        DeliveryItemEntity saved = deliveryItemRepository.save(entity);
        return deliveryItemMapper.toDto(saved);
    }

    public DeliveryItemDto updateDeliveryItem(Integer id, DeliveryItemRequestDto dto) {
        DeliveryItemEntity entity = deliveryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));

        if (dto.getProductId() != null) {
            entity.setProductEntity(productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        }

        if (dto.getDelivery().getId() != null) {
            entity.setDeliveryEntity(deliveryRepository.findById(dto.getDelivery().getId())
                    .orElseThrow(() -> new RuntimeException("Delivery no encontrado")));
        }

        DeliveryItemEntity updated = deliveryItemRepository.save(entity);
        return deliveryItemMapper.toDto(updated);
    }

    public void deleteDeliveryItem(Integer id) {
        DeliveryItemEntity entity = deliveryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));
        deliveryItemRepository.delete(entity);
    }
}

