package ru.salix.ejournal.api.model.api.error;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public class ErrorHttpDto {

    private String originalCode;
    private String originalMessage;
    private String requestDetails;
    private HttpStatus status;
    private List<String> details;

}
