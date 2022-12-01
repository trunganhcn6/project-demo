package dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link entity.BrandAccount} entity
 */
@Data
public class BrandAccountDto implements Serializable {
    @NotBlank
    private final String username;
    @Size(min = 5, max = 30)
    @NotBlank
    @NotNull
    private final String password;
    @Email
    @NotBlank
    @NotNull
    private final String email;
}