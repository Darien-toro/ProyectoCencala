package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryEntity;
import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;
import com.project.springboot.cencala.lavandery.mapper.DeliveryItemMapper;
import com.project.springboot.cencala.lavandery.mapper.DeliveryMapper;
import com.project.springboot.cencala.lavandery.mapper.ProductMapper;
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
    private final ProductMapper productMapper;
    private final DeliveryMapper deliveryMapper;

    public List<DeliveryItemDto> getAll() {
        return deliveryItemRepository.findAll()
                .stream()
                .map(deliveryItemMapper::toDto)
                .toList();
    }

    public DeliveryItemDto getById(Integer id) {
        DeliveryItemEntity entity = deliveryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));
        return deliveryItemMapper.toDto(entity);
    }

    public DeliveryItemDto create(DeliveryItemDto dto) {
        DeliveryItemEntity entity = deliveryItemMapper.toEntity(dto);

        if (dto.getProduct() != null) {
            entity.setProductEntity(productRepository.findById(dto.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        }

        if (dto.getDelivery() != null) {
            entity.setDeliveryEntity(deliveryRepository.findById(dto.getDelivery().getId())
                    .orElseThrow(() -> new RuntimeException("Delivery no encontrado")));
        }

        DeliveryItemEntity saved = deliveryItemRepository.save(entity);
        return deliveryItemMapper.toDto(saved);
    }

    public DeliveryItemDto update(Integer id, DeliveryItemDto dto) {
        deliveryItemRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));

        if (dto.getProduct().getId() != null) {
            ProductEntity productEntity = productRepository.findById(dto.getProduct().getId()) 
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            dto.setProduct(productMapper.toDto(productEntity));
        }

        if (dto.getDelivery() != null) {
            DeliveryEntity deliveryEntity = deliveryRepository.findById(dto.getDelivery().getId())
                    .orElseThrow(() -> new RuntimeException("Delivery no encontrado"));
            dto.setDelivery(deliveryMapper.toDto(deliveryEntity));
        }
        DeliveryItemEntity deliveryItemEntity = deliveryItemMapper.toEntity(dto);
        DeliveryItemEntity update = deliveryItemRepository.save(deliveryItemEntity);
        return deliveryItemMapper.toDto(update);
    }

    public void delete(Integer id) {
        DeliveryItemEntity entity = deliveryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery Item no encontrado"));
        deliveryItemRepository.delete(entity);
    }
}

