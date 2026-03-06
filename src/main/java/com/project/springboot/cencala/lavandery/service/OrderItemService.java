package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.OrderItemDto;
import com.project.springboot.cencala.lavandery.dto.OrderItemRequestDto;
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

    public List<OrderItemDto> getAllOrderItems() {
        return orderItemRepository.findAll()
                .stream()
                .map(orderItemMapper::toDto)
                .toList();
    }

    public OrderItemDto getOrderItemById(Integer id) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));
        return orderItemMapper.toDto(entity);
    }

    public OrderItemDto createOrderItem(OrderItemRequestDto dto) {
        OrderItemEntity entity = orderItemMapper.toEntity(dto);

        // Buscar producto y asignar precio
        ProductEntity product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        entity.setProductEntity(product);

        // Buscar orden
        OrderEntity order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        entity.setOrderEntity(order);

        // Autocompletar unitAmount con el precio del producto
        entity.setUnitAmount(product.getPriceAmount());

        // Calcular totalAmount = cantidad * unitAmount
        entity.setTotalAmount(entity.getUnitAmount().multiply(BigDecimal.valueOf(dto.getQuantity())));

        OrderItemEntity saved = orderItemRepository.save(entity);
        return orderItemMapper.toDto(saved);
    }

    public OrderItemDto updateOrderItem(Integer id, OrderItemRequestDto dto) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));

        // Actualizar campos básicos con el mapper
        orderItemMapper.updateEntityFromDto(dto, entity);

        // Reasignar producto y precio
        if (dto.getProductId() != null) {
            ProductEntity product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            entity.setProductEntity(product);
            entity.setUnitAmount(product.getPriceAmount());
        }

        // Reasignar orden
        if (dto.getOrderId() != null) {
            OrderEntity order = orderRepository.findById(dto.getOrderId())
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

    public void deleteOrderItem(Integer id) {
        OrderItemEntity entity = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Item no encontrado"));
        orderItemRepository.delete(entity);
    }
}

