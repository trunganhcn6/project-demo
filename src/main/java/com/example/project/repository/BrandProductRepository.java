package com.example.project.repository;

import com.example.project.model.entity.BrandProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandProductRepository extends JpaRepository<BrandProduct, Integer> {
    BrandProduct findByName(String name);

}