package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.CustomerCreateDto;
import com.project.springboot.cencala.lavandery.dto.CustomerDto;
import com.project.springboot.cencala.lavandery.entity.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {LegIdTypeMapper.class})
public interface CustomerMapper {
    @Mapping(source = "legIdTypeEntity", target = "legIdType")
    CustomerDto toDTO(CustomerEntity entity);
    @Mapping(source = "legIdType", target = "legIdTypeEntity")
    CustomerEntity toEntity(CustomerCreateDto dto);

}

