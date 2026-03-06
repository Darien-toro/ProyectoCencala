package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.project.springboot.cencala.lavandery.dto.OrderItemDto;
import com.project.springboot.cencala.lavandery.dto.OrderItemRequestDto;
import com.project.springboot.cencala.lavandery.entity.OrderItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {

    @Mapping(source = "productEntity.name", target = "productName")
    @Mapping(source = "orderEntity.id", target = "orderId")
    OrderItemDto toDto(OrderItemEntity entity);

    // Para crear, no mapees productId ni orderId aquí
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productEntity", ignore = true)
    @Mapping(target = "orderEntity", ignore = true)
    @Mapping(target = "unitAmount", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    OrderItemEntity toEntity(OrderItemRequestDto dto);

    // Para actualizar, igual: ignora productEntity y orderEntity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productEntity", ignore = true)
    @Mapping(target = "orderEntity", ignore = true)
    @Mapping(target = "unitAmount", ignore = true)
    @Mapping(target = "totalAmount", ignore = true)
    void updateEntityFromDto(OrderItemRequestDto dto, @MappingTarget OrderItemEntity entity);
}


