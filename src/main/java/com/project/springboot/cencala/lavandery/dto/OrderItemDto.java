package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDto {
    private Integer id;
    private Integer quantity;
    private BigDecimal unitAmount;   // se autocompleta con el precio del producto
    private BigDecimal totalAmount;  // cantidad * unitAmount
    private String productName;      // en vez de productId
    private Integer orderId;
}

