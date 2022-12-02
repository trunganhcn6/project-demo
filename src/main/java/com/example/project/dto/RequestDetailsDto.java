package com.example.project.dto;

import com.example.project.entity.BrandProduct;
import com.example.project.entity.Request;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.project.entity.RequestDetails} entity
 */
@Data
public class RequestDetailsDto implements Serializable {
    private final BrandProduct brandProduct;
    private final Request request;
    private final int productQty;
    private final Boolean isDelivered;
}