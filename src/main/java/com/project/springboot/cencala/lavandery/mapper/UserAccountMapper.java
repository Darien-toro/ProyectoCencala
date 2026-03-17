package com.project.springboot.cencala.lavandery.mapper;

import com.project.springboot.cencala.lavandery.dto.UserDto;
import com.project.springboot.cencala.lavandery.entity.UserAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class, CustomerMapper.class})
public interface UserAccountMapper {

    @Mapping(source = "customerEntity", target = "customer")
    UserDto toDto(UserAccountEntity entity);

    @Mapping(source = "customer", target = "customerEntity")
    UserAccountEntity toEntity(UserDto dto);
}