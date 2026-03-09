package com.project.springboot.cencala.lavandery.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String username;
    private String password;
    private UserTypeDto userType;
    private CustomerDto customer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
