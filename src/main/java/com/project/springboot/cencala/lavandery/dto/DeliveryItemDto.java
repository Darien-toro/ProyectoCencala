package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryItemDto {
    private Integer id;
    private Integer deliveryQuantity;
    private Integer compensationQuantity;
    private String notes;
    private BigDecimal compensationAmount;
    private Integer productId;
    private Integer deliveryId;
}

