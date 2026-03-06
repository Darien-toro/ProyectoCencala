package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderItemDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceOrderItemMapper {
    InvoiceOrderItemDTO toDTO(InvoiceOrderItemEntity entity);
    InvoiceOrderItemEntity toEntity(InvoiceOrderItemDTO dto);
}