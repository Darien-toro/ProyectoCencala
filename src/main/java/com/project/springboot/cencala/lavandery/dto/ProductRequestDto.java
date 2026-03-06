package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequestDto {
    private String code;
    private String name;
    private String description;
    private BigDecimal priceAmount;
    private Integer productLineId; // 👈 aquí sí necesitamos el ID
}
