package com.project.springboot.cencala.lavandery.service;

import java.util.List;
import java.util.stream.Collectors;
import com.project.springboot.cencala.lavandery.mapper.LegIdTypeMapper;
import org.springframework.stereotype.Service;
import com.project.springboot.cencala.lavandery.dto.CustomerDto;
import com.project.springboot.cencala.lavandery.entity.CustomerEntity;
import com.project.springboot.cencala.lavandery.entity.LegIdTypeEntity;
import com.project.springboot.cencala.lavandery.mapper.CustomerMapper;
import com.project.springboot.cencala.lavandery.repository.CustomerRepository;
import com.project.springboot.cencala.lavandery.repository.LegIdTypeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final LegIdTypeRepository legIdTypeRepository;
    private final CustomerMapper customerMapper;
    private final LegIdTypeMapper legIdTypeMapper;

    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDto findById(Integer id) {
        CustomerEntity entity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return customerMapper.toDTO(entity);
    }

    public CustomerDto save(CustomerDto dto) {
        LegIdTypeEntity legIdTypeEntity = legIdTypeRepository.findById(dto.getLegIdType().getId())
                .orElseThrow(() -> new RuntimeException("Id no encontrado"));
        dto.setLegIdType(legIdTypeMapper.toDto(legIdTypeEntity));

        CustomerEntity entity = customerMapper.toEntity(dto);
        entity.setLegIdTypeEntity(legIdTypeEntity);

        CustomerEntity saved = customerRepository.save(entity);

        return customerMapper.toDTO(saved);
    }
    public CustomerDto update(Integer id, CustomerDto dto){
        customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));


        if (dto.getLegIdType().getId() != null) {
            LegIdTypeEntity legIdTypeEntity = legIdTypeRepository.findById(dto.getLegIdType().getId())
                    .orElseThrow(() -> new RuntimeException(" tipo no encontrado"));
            dto.setLegIdType(legIdTypeMapper.toDto(legIdTypeEntity));
        }
        CustomerEntity customerEntity = customerMapper.toEntity(dto);
        CustomerEntity update = customerRepository.save(customerEntity);
        return customerMapper.toDTO(update);
    }
    public void delete(Integer id) {
        CustomerEntity entity = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        customerRepository.delete(entity);
    }

}