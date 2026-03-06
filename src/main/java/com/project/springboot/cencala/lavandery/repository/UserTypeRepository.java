package com.project.springboot.cencala.lavandery.repository;

import com.project.springboot.cencala.lavandery.entity.UserTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserTypeEntity, Integer> {
    
}
