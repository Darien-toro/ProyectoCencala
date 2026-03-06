package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.OrderRequestDto;
import com.project.springboot.cencala.lavandery.dto.OrderResponseDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderResponseDto toResponseDto(OrderEntity entity);
    OrderEntity toEntity(OrderRequestDto dto);
}

