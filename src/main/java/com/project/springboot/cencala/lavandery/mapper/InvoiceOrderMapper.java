package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CustomerMapper.class})
public interface InvoiceOrderMapper {
    @Mapping(source = "customerEntity", target = "customer")
    InvoiceOrderDTO toDTO(InvoiceOrderEntity entity);
    @Mapping(source = "customer", target = "customerEntity")
    InvoiceOrderEntity toEntity(InvoiceOrderDTO dto);
}
