package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.entity.InvoiceOrderItemEntity;

import java.util.List;

@Repository
public interface InvoiceOrderItemRepository extends JpaRepository<InvoiceOrderItemEntity, Integer> {

    List<InvoiceOrderItemEntity> findByInvoiceOrderEntity_Id(Integer invoiceOrderId);
}
