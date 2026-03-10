package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import com.project.springboot.cencala.lavandery.dto.OrderItemDto;
import com.project.springboot.cencala.lavandery.entity.OrderItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class, ProductMapper.class})
public interface OrderItemMapper {
    @Mapping(source = "productEntity", target = "product")
    @Mapping(source = "orderEntity", target = "order")
    OrderItemDto toDto(OrderItemEntity entity);
    @Mapping(source = "product", target = "productEntity")
    @Mapping(source = "order", target = "orderEntity")
    OrderItemEntity toEntity(OrderItemDto dto);
}


