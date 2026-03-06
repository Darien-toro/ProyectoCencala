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
@Table(name="tbl_delivery_item")
public class DeliveryItemEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "delivery_item_id")
    private Integer id;

    @Column(name= "delivery_quantity")
    private Integer deliveryQuantity;

    @Column(name= "compensation_quantity")
    private Integer compensationQuantity;

    @Column(name= "notes")
    private String notes;

    @Column(name= "compensation_amount")
    private BigDecimal compensationAmount;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name= "delivery_id")
    private DeliveryEntity deliveryEntity;
}
