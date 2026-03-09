package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.OrderDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderStatusMapper.class, CustomerMapper.class})
public interface OrderMapper {
    @Mapping(source = "orderStatusEntity", target = "orderStatus")
    @Mapping(source = "customerEntity", target = "customer")
    OrderDto toDto(OrderEntity entity);
    @Mapping(source = "orderStatus", target = "orderStatusEntity")
    @Mapping(source = "customer", target = "customerEntity")
    OrderEntity toEntity(OrderDto dto);
}

