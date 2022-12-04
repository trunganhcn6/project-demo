package com.example.project.repository;

import com.example.project.model.entity.Brand;
import com.example.project.model.entity.BrandAcc;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandAccRepository extends JpaRepository<BrandAcc, Integer> {
    BrandAcc findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    List<BrandAcc> findByBrand(Brand brand);

}