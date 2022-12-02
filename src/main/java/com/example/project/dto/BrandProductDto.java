package com.example.project.dto;

import com.example.project.entity.Color;
import com.example.project.entity.RequestDetails;
import com.example.project.entity.Size;
import com.example.project.entity.Storage;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link com.example.project.entity.BrandProduct} entity
 */
@Data
public class BrandProductDto implements Serializable {
    private final String name;
    private final int pricePerUnit;
    private final LocalDateTime timeToProduce;
    private final Size size;
    private final Color color;
    private final Storage storage;
    private final Set<RequestDetails> requestDetails;
}