package com.project.springboot.cencala.lavandery.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.project.springboot.cencala.lavandery.dto.ProductRequestDto;
import com.project.springboot.cencala.lavandery.dto.ProductDto;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    // Entity → ResponseDto (para GET)
    @Mapping(source = "productLineEntity.name", target = "productLineName")
    ProductDto toDto(ProductEntity entity);

    // RequestDto → Entity (para POST)
    @Mapping(source = "productLineId", target = "productLineEntity.id")
    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "creationDate", ignore = true) 
    @Mapping(target = "lastUpdate", ignore = true)
    ProductEntity toEntity(ProductRequestDto dto);

    // RequestDto → actualizar entidad existente (para PUT)
    @Mapping(source = "productLineId", target = "productLineEntity.id")
    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "creationDate", ignore = true) 
    @Mapping(target = "lastUpdate", ignore = true)
    void updateEntityFromDto(ProductRequestDto dto, @MappingTarget ProductEntity entity);
}

