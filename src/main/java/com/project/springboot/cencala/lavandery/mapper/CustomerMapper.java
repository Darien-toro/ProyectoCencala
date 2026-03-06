package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.CustomerCreateDto;
import com.project.springboot.cencala.lavandery.dto.CustomerDto;
import com.project.springboot.cencala.lavandery.entity.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {LegIdTypeMapper.class})
public interface CustomerMapper {
    CustomerDto toDTO(CustomerEntity entity);
    CustomerEntity toEntity(CustomerCreateDto dto);

}

