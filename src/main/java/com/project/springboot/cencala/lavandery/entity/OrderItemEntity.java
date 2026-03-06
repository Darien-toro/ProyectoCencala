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
import lombok.Setter;;

@Entity
@Getter
@Setter
@Table(name= "tbl_order_item")
public class OrderItemEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "order_item_id")
    private Integer id;

    @Column(name= "quantity")
    private Integer quantity;

    @Column(name= "unit_amount")
    private BigDecimal unitAmount;

    @Column(name= "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
