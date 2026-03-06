package com.project.springboot.cencala.lavandery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name= "tbl_invoice_order")
public class InvoiceOrderEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "invoice_order_id")
    private Integer id;

    @Column(name= "code")
    private String code;

    @Column(name= "invoice_number")
    private String invoiceNumber;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name= "order_count")
    private Long orderCount;

    @Column(name= "total_amount")
    private BigDecimal totalAmount;

    @Column(name= "compensation_amount")
    private BigDecimal compensationAmount;

    @ManyToOne
    @JoinColumn(name= "customer_id")
    private CustomerEntity customerEntity;
}
