package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import com.project.springboot.cencala.lavandery.dto.OrderStatusDto;
import com.project.springboot.cencala.lavandery.entity.OrderStatusEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderStatusMapper {
    OrderStatusDto toDTO(OrderStatusEntity entity);
    OrderStatusEntity toEntity(OrderStatusDto dto);
}
