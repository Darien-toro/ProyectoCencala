package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.UserDto;
import com.project.springboot.cencala.lavandery.entity.CustomerEntity;
import com.project.springboot.cencala.lavandery.entity.UserEntity;
import com.project.springboot.cencala.lavandery.entity.UserTypeEntity;
import com.project.springboot.cencala.lavandery.mapper.UserMapper;
import com.project.springboot.cencala.lavandery.repository.CustomerRepository;
import com.project.springboot.cencala.lavandery.repository.UserRepository;
import com.project.springboot.cencala.lavandery.repository.UserTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserTypeRepository userTypeRepository;
    private final CustomerRepository customerRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public UserDto createUser(UserDto dto) {
        // Mapear DTO a Entity (solo campos básicos)
        UserEntity entity = userMapper.toEntity(dto);

        // Asignar relaciones manualmente
        UserTypeEntity userType = userTypeRepository.findById(dto.getUserTypeId())
                .orElseThrow(() -> new IllegalArgumentException("UserType no encontrado con id: " + dto.getUserTypeId()));
        entity.setUserType(userType);

        CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer no encontrado con id: " + dto.getCustomerId()));
        entity.setCustomer(customer);

        UserEntity saved = userRepository.save(entity);
        return userMapper.toDto(saved);
    }

    public UserDto updateUser(Integer id, UserDto dto) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setUsername(dto.getUsername());
                    existing.setPassword(dto.getPassword());

                    userTypeRepository.findById(dto.getUserTypeId())
                            .ifPresent(existing::setUserType);

                    customerRepository.findById(dto.getCustomerId())
                            .ifPresent(existing::setCustomer);

                    UserEntity updated = userRepository.save(existing);
                    return userMapper.toDto(updated);
                })
                .orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
