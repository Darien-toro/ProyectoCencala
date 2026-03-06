package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.DeliveryDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryEntity;

    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING) 
    public interface DeliveryMapper { 

    @Mapping(source = "orderEntity.id", target = "orderId") 
    DeliveryDto toDto(DeliveryEntity entity);

    @Mapping(source = "orderId", target = "orderEntity.id") 
    DeliveryEntity toEntity(DeliveryDto dto);
}
