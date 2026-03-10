package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.project.springboot.cencala.lavandery.dto.ProductDto;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;

@Mapper(componentModel = "spring", uses = {ProductLineMapper.class} )
public interface ProductMapper {
    @Mapping(source = "productLineEntity", target = "productLine")
    ProductDto toDto(ProductEntity entity);
    @Mapping(source = "productLine", target = "productLineEntity")
    ProductEntity toEntity(ProductDto dto);
}

