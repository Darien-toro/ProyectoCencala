package com.project.springboot.cencala.lavandery.mapper;

import com.project.springboot.cencala.lavandery.dto.UserDto;
import com.project.springboot.cencala.lavandery.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
    UserTypeMapper.class
})
public interface UserMapper {

    @Mapping(source = "userType.id", target = "userTypeId")
    @Mapping(source = "customer.id", target = "customerId")
    UserDto toDto(UserEntity entity);

    // No intentes mapear IDs a objetos aquí
    UserEntity toEntity(UserDto dto);
}