package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.InvoiceOrderDTO;
import com.project.springboot.cencala.lavandery.entity.InvoiceOrderEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceOrderMapper {
    InvoiceOrderDTO toDTO(InvoiceOrderEntity entity);
    InvoiceOrderEntity toEntity(InvoiceOrderDTO dto);
}
