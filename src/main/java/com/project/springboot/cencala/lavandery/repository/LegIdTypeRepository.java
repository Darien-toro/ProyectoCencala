package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.entity.LegIdTypeEntity;

@Repository
public interface LegIdTypeRepository extends JpaRepository<LegIdTypeEntity, Integer>{

}
