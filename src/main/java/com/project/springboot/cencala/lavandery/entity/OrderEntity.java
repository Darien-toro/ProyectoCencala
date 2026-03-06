package com.project.springboot.cencala.lavandery.entity;


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
import lombok.Setter;;

@Entity
@Getter
@Setter
@Table(name="tbl_order")
public class OrderEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "order_id")
    private Integer id;

    @Column(name= "code")
    private String code;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    
    @ManyToOne
    @JoinColumn(name= "order_status_id")
    private OrderStatusEntity orderStatusEntity;
    
    @ManyToOne
    @JoinColumn(name= "customer_id")
    private CustomerEntity customerEntity;
}
