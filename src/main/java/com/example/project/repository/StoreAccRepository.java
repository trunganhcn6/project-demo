package com.example.project.repository;

import com.example.project.model.entity.StoreAcc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreAccRepository extends JpaRepository<StoreAcc, Integer> {
    StoreAcc findByUsername(String username);
}