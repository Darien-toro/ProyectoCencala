package com.project.springboot.cencala.lavandery.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderWithItemsDto {
    private Integer orderId;
    private String orderCode;
    private LocalDateTime creationDate;
    private Integer customerId;

    private Integer itemId;
    private Integer quantity;
    private BigDecimal unitAmount;
    private BigDecimal totalAmount;

    private Integer productId;
    private String productName;
}

