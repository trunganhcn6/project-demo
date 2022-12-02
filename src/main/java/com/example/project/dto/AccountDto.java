package com.example.project.dto;

import com.example.project.entity.Brand;
import com.example.project.entity.Store;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link com.example.project.entity.Account} entity
 */
@Data
public class AccountDto implements Serializable {
    @NotBlank
    private final String username;
    @Email
    @NotBlank
    private final String email;
    private final Store store;
    private final Brand brand;
    @NotBlank
    private final String password;
}