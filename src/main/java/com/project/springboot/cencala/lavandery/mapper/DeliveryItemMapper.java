package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class, DeliveryMapper.class})
public interface DeliveryItemMapper {
    @Mapping(source = "productEntity", target = "product")
    @Mapping(source = "deliveryEntity", target = "delivery")
    DeliveryItemDto toDto(DeliveryItemEntity entity);

    @Mapping(source = "product", target = "productEntity")
    @Mapping(source = "delivery", target = "deliveryEntity")
    DeliveryItemEntity toEntity(DeliveryItemDto dto);
}

