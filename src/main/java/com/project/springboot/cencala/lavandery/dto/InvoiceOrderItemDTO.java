package com.project.springboot.cencala.lavandery.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class InvoiceOrderItemDTO {
    private Integer id;
    private BigDecimal totalAmount;
    private BigDecimal compensationAmount;
    private Integer orderId;        // en lugar de OrderEntity completa
    private Integer invoiceOrderId; // en lugar de InvoiceOrderEntity completa
}
