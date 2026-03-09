package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import com.project.springboot.cencala.lavandery.dto.OrderStatusDto;
import com.project.springboot.cencala.lavandery.entity.OrderStatusEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderStatusMapper {
    OrderStatusDto toDTO(OrderStatusEntity entity);
    OrderStatusEntity toEntity(OrderStatusDto dto);
}
