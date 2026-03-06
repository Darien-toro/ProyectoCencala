package com.project.springboot.cencala.lavandery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "tbl_legal_id_type")
public class LegIdTypeEntity{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "legal_id_type_id")
    private Integer id;

    @Column(name= "abbrev")
    private String abbrev;

    @Column(name= "name")
    private String name;
}
