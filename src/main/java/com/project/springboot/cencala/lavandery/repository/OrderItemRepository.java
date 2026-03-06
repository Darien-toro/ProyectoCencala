package com.project.springboot.cencala.lavandery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.springboot.cencala.lavandery.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity ,Integer>{

}
