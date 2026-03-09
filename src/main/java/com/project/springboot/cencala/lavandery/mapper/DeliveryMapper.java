package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import com.project.springboot.cencala.lavandery.dto.DeliveryDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class}) 
public interface DeliveryMapper {
    @Mapping(source = "orderEntity", target = "order")
    DeliveryDto toDto(DeliveryEntity entity);
    @Mapping(source = "order", target = "orderEntity")
    DeliveryEntity toEntity(DeliveryDto dto);
}
