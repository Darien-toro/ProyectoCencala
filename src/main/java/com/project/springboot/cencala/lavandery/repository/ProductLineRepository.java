package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.springboot.cencala.lavandery.entity.ProductLineEntity;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLineEntity, Integer> {
}

