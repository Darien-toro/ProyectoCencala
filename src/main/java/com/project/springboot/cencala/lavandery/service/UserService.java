package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.UserDto;
import com.project.springboot.cencala.lavandery.entity.UserEntity;
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
        UserEntity entity = userMapper.toEntity(dto);
        if (dto.getUserType().getId() != null) {
            entity.setUserTypeEntity(userTypeRepository.findById(dto.getUserType().getId())
                    .orElseThrow(() -> new RuntimeException("UserType no encontrado")));
            dto.setUserType(userMapper.toDto(entity).getUserType());
        }
        if (dto.getCustomer().getId() != null) {
            entity.setCustomerEntity(customerRepository.findById(dto.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Customer no encontrado")));
            dto.setCustomer(userMapper.toDto(entity).getCustomer());
        }
        UserEntity saved = userRepository.save(userMapper.toEntity(dto));
        return userMapper.toDto(saved);
    }
 
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
