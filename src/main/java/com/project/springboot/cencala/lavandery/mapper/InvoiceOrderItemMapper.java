package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderItemDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {OrderMapper.class, InvoiceOrderMapper.class})
public interface InvoiceOrderItemMapper {
    @Mapping(source = "orderEntity", target = "order")
    @Mapping(source = "invoiceOrderEntity", target = "invoiceOrder")
    InvoiceOrderItemDTO toDto(InvoiceOrderItemEntity entity);

    @Mapping(source = "order", target = "orderEntity")
    @Mapping(source = "invoiceOrder", target = "invoiceOrderEntity")
    InvoiceOrderItemEntity toEntity(InvoiceOrderItemDTO dto);
}