package com.project.springboot.cencala.lavandery.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.project.springboot.cencala.lavandery.dto.CustomerCreateDto;
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

    public CustomerDto createCustomer(CustomerCreateDto dto){
        LegIdTypeEntity legIdTypeEntity = legIdTypeRepository.findById(dto.getLegIdType().getId())
        .orElseThrow(() -> new RuntimeException("Id no encontrado"));

        CustomerEntity entity = customerMapper.toEntity(dto);
        entity.setLegIdTypeEntity(legIdTypeEntity);

        CustomerEntity saved = customerRepository.save(entity);

        return customerMapper.toDTO(saved);
    }

    public List<CustomerDto> getAllCustomers(){
        return customerRepository.findAll()
        .stream()
        .map(customerMapper::toDTO)
        .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(Integer id){
        CustomerEntity entity = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));
        return customerMapper.toDTO(entity);
    }

    public void deleteCustomer(Integer id){
        CustomerEntity entity = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        customerRepository.delete(entity);
    }
    public CustomerDto updateCustomer(Integer id, CustomerCreateDto dto){
        customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No encontrado"));


        if (dto.getLegIdType().getId() != null) {
            legIdTypeRepository.findById(dto.getLegIdType().getId())
                .orElseThrow(() -> new RuntimeException(" tipo no encontrado"));
        }
        CustomerEntity customerEntity = customerMapper.toEntity(dto);
        CustomerEntity update = customerRepository.save(customerEntity);
        return customerMapper.toDTO(update);
        }
    }

