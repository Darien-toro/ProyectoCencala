package com.project.springboot.cencala.lavandery.mapper;

import com.project.springboot.cencala.lavandery.dto.RoleDto;
import com.project.springboot.cencala.lavandery.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    RoleDto toDto(RoleEntity entity);
    RoleEntity toEntity(RoleDto dto);
}
