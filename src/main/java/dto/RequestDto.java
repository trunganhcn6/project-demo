package dto;

import entity.RequestDetails;
import entity.Storage;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * A DTO for the {@link entity.Request} entity
 */
@Data
public class RequestDto implements Serializable {
    private final LocalDateTime dateCreated;
    private final Storage storage;
    private final Set<RequestDetails> requestDetails;
    private final Boolean isCompleted;
}