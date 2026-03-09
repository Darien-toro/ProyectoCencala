package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.OrderItemDto;
import com.project.springboot.cencala.lavandery.entity.OrderItemEntity;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;
import com.project.springboot.cencala.lavandery.mapper.OrderItemMapper;
import com.project.springboot.cencala.lavandery.repository.OrderItemRepository;
import com.project.springboot.cencala.lavandery.repository.ProductRepository;
import com.project.springboot.cencala.lavandery.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public List<OrderItemDto> findAll() {
        return orderItemRepository.findAll()
                .stream()
                .map(orderItemMapper::toDto)
                .toList();
    }

    public OrderItemDto findById(Integer id) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));
        return orderItemMapper.toDto(entity);
    }

    public OrderItemDto save(OrderItemDto dto) {
        OrderItemEntity entity = orderItemMapper.toEntity(dto);

        // Buscar producto y asignar precio
        ProductEntity product = productRepository.findById(dto.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        entity.setProductEntity(product);

        // Buscar orden
        OrderEntity order = orderRepository.findById(dto.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        entity.setOrderEntity(order);

        // Autocompletar unitAmount con el precio del producto
        entity.setUnitAmount(product.getPriceAmount());

        // Calcular totalAmount = cantidad * unitAmount
        entity.setTotalAmount(entity.getUnitAmount().multiply(BigDecimal.valueOf(dto.getQuantity())));

        OrderItemEntity saved = orderItemRepository.save(entity);
        return orderItemMapper.toDto(saved);
    }

    public OrderItemDto update(Integer id, OrderItemDto dto) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));

        // Reasignar producto y precio
        if (dto.getProduct().getId() != null) {
            ProductEntity product = productRepository.findById(dto.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            entity.setProductEntity(product);
            entity.setUnitAmount(product.getPriceAmount());
        }

        // Reasignar orden
        if (dto.getOrder().getId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrder().getId())
                    .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
            entity.setOrderEntity(order);
        }

        // Recalcular totalAmount
        if (dto.getQuantity() != null && entity.getUnitAmount() != null) {
            entity.setTotalAmount(entity.getUnitAmount().multiply(BigDecimal.valueOf(dto.getQuantity())));
        }

        OrderItemEntity updated = orderItemRepository.save(entity);
        return orderItemMapper.toDto(updated);
    }

    public void delete(Integer id) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));
        orderItemRepository.delete(entity);
    }
}

