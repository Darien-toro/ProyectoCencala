package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderItemDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderItemEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceOrderItemMapper {

    @Mapping(source = "orderEntity.id", target = "orderId")
    @Mapping(source = "invoiceOrderEntity.id", target = "invoiceOrderId")
    InvoiceOrderItemDTO toDTO(InvoiceOrderItemEntity entity);

    @Mapping(source = "orderId", target = "orderEntity.id")
    @Mapping(source = "invoiceOrderId", target = "invoiceOrderEntity.id")
    InvoiceOrderItemEntity toEntity(InvoiceOrderItemDTO dto);
}