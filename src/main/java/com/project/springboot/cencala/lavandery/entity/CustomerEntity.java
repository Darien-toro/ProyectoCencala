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
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="tbl_customer")
public class CustomerEntity {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "legal_id_type_id")
    private LegIdTypeEntity legIdTypeEntity;

    @Column(name="legal_id")
    private String legalId;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name= "company_name")
    private String companyName;

    @Column(name= "created_at")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name= "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
