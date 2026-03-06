package com.project.springboot.cencala.lavandery.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryDto {

    private Integer id;
    private LocalDateTime createDate; 
    private Integer orderId;
}
