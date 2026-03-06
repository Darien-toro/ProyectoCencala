package com.project.springboot.cencala.lavandery.mapper;

import com.project.springboot.cencala.lavandery.dto.UserTypeDto;
import com.project.springboot.cencala.lavandery.entity.UserTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserTypeMapper {
    UserTypeDto toDto(UserTypeEntity entity);
    UserTypeEntity toEntity(UserTypeDto dto);
}
