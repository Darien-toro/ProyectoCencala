package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.OrderRequestDto;
import com.project.springboot.cencala.lavandery.dto.OrderResponseDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    // De Entity a ResponseDto (para GET)
    @Mapping(source = "orderStatusEntity.name", target = "orderStatusName")
    @Mapping(source = "customerEntity.firstName", target = "customerName")
    OrderResponseDto toResponseDto(OrderEntity entity);

    // De RequestDto a Entity (para POST/PUT)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(source = "orderStatusId", target = "orderStatusEntity.id")
    @Mapping(source = "customerId", target = "customerEntity.id")
    OrderEntity toEntity(OrderRequestDto dto);
}

