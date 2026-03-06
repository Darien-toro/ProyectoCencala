package com.project.springboot.cencala.lavandery.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class InvoiceOrderDTO {
    private Integer id;
    private String code;
    private String invoiceNumber;
    private LocalDateTime createdDate;
    private Long orderCount;
    private BigDecimal totalAmount;
    private BigDecimal compensationAmount;
    private CustomerDto customer;
}
