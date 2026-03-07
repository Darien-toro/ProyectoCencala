package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.OrderRequestDto;
import com.project.springboot.cencala.lavandery.dto.OrderResponseDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "orderStatusEntity", target = "orderStatus")
    @Mapping(source = "customerEntity", target = "customer")
    OrderResponseDto toResponseDto(OrderEntity entity);
    @Mapping(source = "orderStatus", target = "orderStatusEntity")
    @Mapping(source = "customer", target = "customerEntity")
    OrderEntity toEntity(OrderRequestDto dto);
}

