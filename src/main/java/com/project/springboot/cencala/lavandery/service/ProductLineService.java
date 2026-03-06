package com.project.springboot.cencala.lavandery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.ProductLineDto;
import com.project.springboot.cencala.lavandery.entity.ProductLineEntity;
import com.project.springboot.cencala.lavandery.mapper.ProductLineMapper;
import com.project.springboot.cencala.lavandery.repository.ProductLineRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductLineService {

    private final ProductLineRepository productLineRepository;
    private final ProductLineMapper productLineMapper;

    public List<ProductLineDto> getAllProductLines() {
        return productLineRepository.findAll()
                .stream()
                .map(productLineMapper::toDto)
                .toList();
    }

    public ProductLineDto getProductLineById(Integer id) {
        ProductLineEntity entity = productLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Línea de producto no encontrada"));
        return productLineMapper.toDto(entity);
    }

    public ProductLineDto createProductLine(ProductLineDto dto) {
        ProductLineEntity entity = productLineMapper.toEntity(dto);
        ProductLineEntity saved = productLineRepository.save(entity);
        return productLineMapper.toDto(saved);
    }

    public ProductLineDto updateProductLine(Integer id, ProductLineDto dto) {
        ProductLineEntity entity = productLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Línea de producto no encontrada"));

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        ProductLineEntity updated = productLineRepository.save(entity);
        return productLineMapper.toDto(updated);
    }

    public void deleteProductLine(Integer id) {
        ProductLineEntity entity = productLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Línea de producto no encontrada"));
        productLineRepository.delete(entity);
    }
}

