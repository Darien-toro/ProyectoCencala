package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.CustomerCreateDto;
import com.project.springboot.cencala.lavandery.dto.CustomerDto;
import com.project.springboot.cencala.lavandery.entity.CustomerEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {LegIdTypeMapper.class})
public interface CustomerMapper {
    @Mapping(source = "legIdTypeEntity.name", target = "legIdTypeName")
    CustomerDto toDTO(CustomerEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source ="legIdTypeId", target = "legIdTypeEntity.id")
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    CustomerEntity toEntity(CustomerCreateDto dto);

}

