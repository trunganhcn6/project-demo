package com.example.project.model.dto;

import com.example.project.model.entity.Store;
import com.example.project.model.entity.StoreAcc;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link StoreAcc} entity
 */
@Data
public class StoreAccDto implements Serializable {
    @NotBlank
    private final String username;
    @Email
    @NotBlank
    private final String email;
    private final Store store;
    @NotBlank
    private final String password;
}