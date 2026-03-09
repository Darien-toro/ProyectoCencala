package com.project.springboot.cencala.lavandery.mapper;

import com.project.springboot.cencala.lavandery.dto.UserDto;
import com.project.springboot.cencala.lavandery.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserTypeMapper.class, CustomerMapper.class})
public interface UserMapper {

    @Mapping(source = "userTypeEntity", target = "userType")
    @Mapping(source = "customerEntity", target = "customer")
    UserDto toDto(UserEntity entity);

    @Mapping(source = "userType", target = "userTypeEntity")
    @Mapping(source = "customer", target = "customerEntity")
    UserEntity toEntity(UserDto dto);
}