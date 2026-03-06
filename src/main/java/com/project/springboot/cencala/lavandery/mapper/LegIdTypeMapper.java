package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.project.springboot.cencala.lavandery.dto.LegIdTypeDto;
import com.project.springboot.cencala.lavandery.entity.LegIdTypeEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LegIdTypeMapper {

    LegIdTypeDto toDto(LegIdTypeEntity entity);
    LegIdTypeEntity  toEntity(LegIdTypeDto dto);
}
