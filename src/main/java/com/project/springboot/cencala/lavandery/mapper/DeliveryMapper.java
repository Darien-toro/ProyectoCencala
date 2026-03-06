package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.DeliveryDto;
import com.project.springboot.cencala.lavandery.entity.DeliveryEntity;

    @Mapper(componentModel = MappingConstants.ComponentModel.SPRING) 
    public interface DeliveryMapper {
    DeliveryDto toDto(DeliveryEntity entity);
    DeliveryEntity toEntity(DeliveryDto dto);
}
