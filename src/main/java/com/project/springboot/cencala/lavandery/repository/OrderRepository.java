package com.project.springboot.cencala.lavandery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.springboot.cencala.lavandery.dto.OrderWithItemsDto;
import com.project.springboot.cencala.lavandery.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity ,Integer>{

    @Query("SELECT new com.project.springboot.cencala.lavandery.dto.OrderWithItemsDto(" +
           "o.id, o.code, o.creationDate, o.customerEntity.id, " +
           "i.id, i.quantity, i.unitAmount, i.totalAmount, " +
           "p.id, p.name) " +
           "FROM OrderEntity o " +
           "JOIN o.customerEntity c " +
           "JOIN OrderItemEntity i ON i.orderEntity.id = o.id " +
           "JOIN i.productEntity p " +
           "WHERE c.id = :customerId")
    List<OrderWithItemsDto> findOrdersWithItemsByCustomerId(@Param("customerId") Integer customerId);
}

