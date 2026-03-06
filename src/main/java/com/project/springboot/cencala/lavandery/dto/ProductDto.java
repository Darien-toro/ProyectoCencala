package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private BigDecimal priceAmount;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private ProductLineDto productLine;
}



