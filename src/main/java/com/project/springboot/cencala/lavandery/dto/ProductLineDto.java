package com.project.springboot.cencala.lavandery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductLineDto {
    private Integer id;
    private String name;
    private String description;
}

