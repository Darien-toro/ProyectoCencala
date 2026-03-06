package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    // Aquí puedes agregar métodos personalizados si lo necesitas, por ejemplo:
    // Optional<CustomerEntity> findByLegalId(String legalId);
}
