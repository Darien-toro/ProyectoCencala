package com.project.springboot.cencala.lavandery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.ProductDto;
import com.project.springboot.cencala.lavandery.dto.ProductRequestDto;
import com.project.springboot.cencala.lavandery.entity.ProductEntity;
import com.project.springboot.cencala.lavandery.mapper.ProductMapper;
import com.project.springboot.cencala.lavandery.repository.ProductRepository;
import com.project.springboot.cencala.lavandery.repository.ProductLineRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductLineRepository productLineRepository;

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(Integer id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productMapper.toDto(entity);
    }

    public ProductDto createProduct(ProductRequestDto dto) {
        ProductEntity entity = productMapper.toEntity(dto);

        if (dto.getProductLineId() != null) {
            entity.setProductLineEntity(productLineRepository.findById(dto.getProductLineId())
                    .orElseThrow(() -> new RuntimeException("Línea de producto no encontrada")));
        }

        ProductEntity saved = productRepository.save(entity);
        return productMapper.toDto(saved);
    }

    public ProductDto updateProduct(Integer id, ProductRequestDto dto) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (dto.getProductLineId() != null) {
            productLineRepository.findById(dto.getProductLineId())
                    .orElseThrow(() -> new RuntimeException("Línea de producto no encontrada"));
        }
        ProductEntity updated = productRepository.save(productMapper.toEntity(dto));
        return productMapper.toDto(updated);
    }

    public void deleteProduct(Integer id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(entity);
    }
}

