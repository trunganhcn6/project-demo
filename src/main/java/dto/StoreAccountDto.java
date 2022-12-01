package dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * A DTO for the {@link entity.StoreAccount} entity
 */
@Data
public class StoreAccountDto implements Serializable {
    @NotBlank
    private final String username;
    @Email
    @NotBlank
    private final String email;
    @NotBlank
    private final String password;
}