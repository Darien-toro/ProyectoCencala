package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import com.project.springboot.cencala.lavandery.dto.ProductLineDto;
import com.project.springboot.cencala.lavandery.entity.ProductLineEntity;

@Mapper(componentModel = "spring")
public interface ProductLineMapper {
    ProductLineDto toDto(ProductLineEntity entity);
    ProductLineEntity toEntity(ProductLineDto dto);
}

