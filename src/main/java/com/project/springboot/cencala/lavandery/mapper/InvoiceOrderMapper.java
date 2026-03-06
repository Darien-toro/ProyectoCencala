package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceOrderMapper {

    @Mapping(source = "customerEntity.id", target = "customerId")
    InvoiceOrderDTO toDTO(InvoiceOrderEntity entity);

    @Mapping(source = "customerId", target = "customerEntity.id")
    InvoiceOrderEntity toEntity(InvoiceOrderDTO dto);
}
