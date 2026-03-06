package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.entity.InvoiceOrderEntity;

import org.springframework.data.repository.query.Param;

@Repository
public interface InvoiceOrderRepository extends JpaRepository<InvoiceOrderEntity, Integer> {

    @Procedure(procedureName = "prc_process_invoice_order")
    void processInvoiceOrder(@Param("pv_month") Integer month, @Param("pv_year") Integer year);
}
