package com.example.project.model.dto;

import com.example.project.model.entity.RequestDetails;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link com.example.project.model.entity.Request} entity
 */
@Data
public class RequestDto implements Serializable {
    private final LocalDateTime dateCreated;
    private final Set<RequestDetails> requestDetails;
    private final Boolean isCompleted;
}