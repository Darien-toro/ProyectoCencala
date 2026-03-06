package com.project.springboot.cencala.lavandery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemRequestDto {
    private Integer quantity;
    private ProductDto product; // el cliente envía el ID del producto
    private OrderDto order;   // el cliente envía el ID de la orden
}

