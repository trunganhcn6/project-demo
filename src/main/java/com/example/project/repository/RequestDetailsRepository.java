package com.example.project.repository;

import com.example.project.model.entity.RequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetailsRepository extends JpaRepository<RequestDetails, Integer> {
}