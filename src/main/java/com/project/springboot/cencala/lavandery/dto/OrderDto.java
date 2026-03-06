package com.project.springboot.cencala.lavandery.dto;

import com.project.springboot.cencala.lavandery.entity.CustomerEntity;
import com.project.springboot.cencala.lavandery.entity.OrderStatusEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Integer id;
    private String code;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private OrderStatusDto orderStatus;
    private CustomerDto customer;
}
