package com.project.springboot.cencala.lavandery.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.LegIdTypeDto;
import com.project.springboot.cencala.lavandery.entity.LegIdTypeEntity;
import com.project.springboot.cencala.lavandery.mapper.LegIdTypeMapper;
import com.project.springboot.cencala.lavandery.repository.LegIdTypeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LegIdTypeService {

    private final LegIdTypeRepository legIdTypeRepository;
    private final LegIdTypeMapper legIdTypeMapper;

    public List<LegIdTypeDto> findAll(){
        return legIdTypeRepository.findAll()
        .stream()
        .map(legIdTypeMapper::toDto)
        .collect(Collectors.toList());
    }
    
    public LegIdTypeDto findById(Integer id){
        return legIdTypeRepository.findById(id)
        .map(legIdTypeMapper::toDto)
        .orElse(null);
    }

    public LegIdTypeDto  save(LegIdTypeDto dto){
        return legIdTypeMapper.toDto(legIdTypeRepository.save(legIdTypeMapper.toEntity(dto)));
    }

    public void delete(Integer id){
        legIdTypeRepository.deleteById(id);
    }

    public LegIdTypeDto update(Integer id, LegIdTypeDto dto){
        LegIdTypeEntity entity = legIdTypeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));

        LegIdTypeEntity update = legIdTypeRepository.save(legIdTypeMapper.toEntity(dto));
        return legIdTypeMapper.toDto(update);
    }
}
