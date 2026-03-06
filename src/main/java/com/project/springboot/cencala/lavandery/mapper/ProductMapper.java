package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.project.springboot.cencala.lavandery.dto.ProductRequestDto;
import com.project.springboot.cencala.lavandery.dto.ProductDto;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;

@Mapper(componentModel = "spring", uses = ProductLineMapper.class)
public interface ProductMapper {
    @Mapping(source = "productLineEntity.id", target = "productLine.id")
    @Mapping(source = "productLineEntity.name", target = "productLine.name")
    @Mapping(source = "productLineEntity.description", target = "productLine.description")
    ProductDto toDto(ProductEntity entity);
    @Mapping(source = "productLine.id", target = "productLineEntity.id")
    @Mapping(source = "productLine.name", target = "productLineEntity.name")
    @Mapping(source = "productLine.description", target = "productLineEntity.description")
    ProductEntity toEntity(ProductRequestDto dto);
}

