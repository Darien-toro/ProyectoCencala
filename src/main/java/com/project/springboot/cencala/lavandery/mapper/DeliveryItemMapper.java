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
    DeliveryItemDto toDto(DeliveryItemEntity entity);
    DeliveryItemEntity toEntity(DeliveryItemRequestDto dto);
}

