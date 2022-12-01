package dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link entity.Brand} entity
 */
@Data
public class BrandDto implements Serializable {
    @Size(min = 5, max = 100)
    @NotBlank
    private final String name;
    @Size(min = 5, max = 100)
    @NotBlank
    private final String address;
}