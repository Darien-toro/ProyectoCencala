package com.project.springboot.cencala.lavandery.service;

import com.project.springboot.cencala.lavandery.dto.UserTypeDto;
import com.project.springboot.cencala.lavandery.entity.UserTypeEntity;
import com.project.springboot.cencala.lavandery.mapper.UserTypeMapper;
import com.project.springboot.cencala.lavandery.repository.UserTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserTypeService {

    private final UserTypeRepository userRepository;
    private final UserTypeMapper userMapper;

    public List<UserTypeDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserTypeDto getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public UserTypeDto createUser(UserTypeDto userDto) {
        UserTypeEntity entity = userMapper.toEntity(userDto);
        UserTypeEntity saved = userRepository.save(entity);
        return userMapper.toDto(saved);
    }

    public UserTypeDto updateUser(Integer id, UserTypeDto userDto) {
        return userRepository.findById(id)
                .map(existing -> {
                    existing.setUserType(userDto.getUserType());
                    UserTypeEntity updated = userRepository.save(existing);
                    return userMapper.toDto(updated);
                })
                .orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
