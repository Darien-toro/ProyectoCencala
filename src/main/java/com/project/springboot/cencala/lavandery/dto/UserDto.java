package com.project.springboot.cencala.lavandery.dto;

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
    private Integer userTypeId;
    private Integer customerId;
}
