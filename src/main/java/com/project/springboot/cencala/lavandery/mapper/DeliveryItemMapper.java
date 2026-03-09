package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class, DeliveryMapper.class})
public interface DeliveryItemMapper {
    @Mapping(source = "productEntity.id", target = "productId")
    @Mapping(source = "deliveryEntity.id", target = "deliveryId")
    DeliveryItemDto toDto(DeliveryItemEntity entity);

    @Mapping(source = "productId", target = "productEntity.id")
    @Mapping(source = "deliveryId", target = "deliveryEntity.id")
    DeliveryItemEntity toEntity(DeliveryItemDto dto);
}

