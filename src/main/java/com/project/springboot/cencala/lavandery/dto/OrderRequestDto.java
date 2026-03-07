package com.project.springboot.cencala.lavandery.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequestDto {
    private Integer id;
    private OrderStatusDto orderStatus;
    private CustomerDto customer;
    private String code;
}

