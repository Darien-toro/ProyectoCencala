package com.project.springboot.cencala.lavandery.entity;

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
@Table(name="tbl_delivery")
public class DeliveryEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "delivery_id")
    private Integer id;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime createDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
}
