package com.project.springboot.cencala.lavandery.entity;

import java.math.BigDecimal;

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
@Table(name= "tbl_invoice_order_item")
public class InvoiceOrderItemEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "invoice_order_item_id")
    private Integer id;

    @Column(name= "total_amount")
    private BigDecimal totalAmount;

    @Column(name= "compensation_amount")
    private BigDecimal compensationAmount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "invoice_order_id")
    private InvoiceOrderEntity invoiceOrderEntity;
}
