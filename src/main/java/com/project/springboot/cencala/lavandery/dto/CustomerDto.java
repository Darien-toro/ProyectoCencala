package com.project.springboot.cencala.lavandery.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private Integer id;
    private String legalId;
    private String firstName;
    private String lastName;
    private String companyName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LegIdTypeDto legIdType;
}

