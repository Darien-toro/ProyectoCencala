package com.project.springboot.cencala.lavandery.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name= "tbl_product")
public class ProductEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "product_id")
    private Integer id;

    @Column(name= "code")
    private String code;

    @Column(name= "name")
    private String name;

    @Column(name= "description")
    private String description;

    @Column(name= "price_amount")
    private BigDecimal priceAmount;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name="product_line_id")
    private ProductLineEntity productLineEntity;
}
