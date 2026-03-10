package com.project.springboot.cencala.lavandery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Integer id;
    private String code;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private OrderStatusDto orderStatus;
    private CustomerDto customer;
}
