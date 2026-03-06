package com.project.springboot.cencala.lavandery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemRequestDto {
    private Integer quantity;
    private Integer productId; // el cliente envía el ID del producto
    private Integer orderId;   // el cliente envía el ID de la orden
}

