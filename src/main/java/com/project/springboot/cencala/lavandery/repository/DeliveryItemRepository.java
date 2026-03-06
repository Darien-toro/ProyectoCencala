package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.entity.DeliveryItemEntity;

@Repository
public interface DeliveryItemRepository extends JpaRepository<DeliveryItemEntity, Integer> {
    // Si necesitas queries personalizadas, puedes agregarlas aquí
}

