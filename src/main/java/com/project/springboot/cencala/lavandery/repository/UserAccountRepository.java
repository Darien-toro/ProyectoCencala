package com.project.springboot.cencala.lavandery.repository;

import com.project.springboot.cencala.lavandery.entity.UserAccountEntity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Integer> {
    Optional<UserAccountEntity> findByUsername(String username);

}
