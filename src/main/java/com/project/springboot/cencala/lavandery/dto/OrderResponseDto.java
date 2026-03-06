package com.project.springboot.cencala.lavandery.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDto {
    private Integer id;
    private String code;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private String orderStatusName;
    private String customerName;
}

