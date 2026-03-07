package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequestDto {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private BigDecimal priceAmount;
    private ProductLineDto productLine;
}
