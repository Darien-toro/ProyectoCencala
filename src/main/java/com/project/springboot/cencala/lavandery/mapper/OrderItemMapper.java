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
    OrderItemDto toDto(OrderItemEntity entity);
    OrderItemEntity toEntity(OrderItemRequestDto dto);
}


