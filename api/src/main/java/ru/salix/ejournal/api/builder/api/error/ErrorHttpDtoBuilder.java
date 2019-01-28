package ru.salix.ejournal.api.builder.api.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import ru.salix.ejournal.api.model.api.error.ErrorHttpDto;
import ru.salix.ejournal.error.exception.BaseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInternalException;

@Component
public class ErrorHttpDtoBuilder {

    public ErrorHttpDto build(Exception e, HttpStatus status, WebRequest request) {
        var baseException = e instanceof BaseException ? (BaseException) e : newInternalException(e, resolve());
        return build(baseException, status, request);
    }

    private ErrorHttpDto build(BaseException e, HttpStatus status, WebRequest request) {
        return ErrorHttpDto.builder()
                .status(status)
                .originalMessage(e.getOriginalMessage())
                .originalCode(e.getFullErrorCode())
                .requestDetails(buildRequestDetails(request))
                .details(buildDetails(e, new ArrayList<>()))
                .build();
    }

    private List<String> buildDetails(Throwable e, List<String> messages) {
        messages.add(e.getMessage());
        ofNullable(e.getCause()).ifPresent(cause -> buildDetails(cause, messages));
        return messages;
    }

    private String buildRequestDetails(WebRequest request) {
        var contextPath = request.getContextPath();
        Map<String, String[]> headers = new HashMap<>();
        request.getHeaderNames().forEachRemaining(name -> headers.put(name, request.getHeaderValues(name)));
        return String.format("ContextPath: %s; Headers: %s", contextPath, headers);
    }

}
