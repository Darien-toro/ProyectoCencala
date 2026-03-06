package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import com.project.springboot.cencala.lavandery.dto.DeliveryItemDto;
import com.project.springboot.cencala.lavandery.dto.DeliveryItemRequestDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryItemMapper {

    // Entity → ResponseDto
    @Mapping(source = "productEntity.name", target = "productName")
    @Mapping(source = "deliveryEntity.id", target = "deliveryId")
    DeliveryItemDto toDto(DeliveryItemEntity entity);

    // RequestDto → Entity
    @Mapping(source = "productId", target = "productEntity.id")
    @Mapping(source = "deliveryId", target = "deliveryEntity.id")
    @Mapping(target = "id", ignore = true)
    DeliveryItemEntity toEntity(DeliveryItemRequestDto dto);

    // RequestDto → actualizar entidad existente
    @Mapping(source = "productId", target = "productEntity.id")
    @Mapping(source = "deliveryId", target = "deliveryEntity.id")
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(DeliveryItemRequestDto dto, @MappingTarget DeliveryItemEntity entity);
}

