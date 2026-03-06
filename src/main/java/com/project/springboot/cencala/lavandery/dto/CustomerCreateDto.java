package com.project.springboot.cencala.lavandery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerCreateDto {

    private String legalId;
    private String firstName;
    private String lastName;
    private String companyName;
    private Integer legIdTypeId;
}
