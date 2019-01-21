package ru.salix.ejournal.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.salix.ejournal.api.builder.dto.ErrorHttpDtoBuilder;
import ru.salix.ejournal.api.controller.dto.ErrorHttpDto;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class ExceptionControllerAdvice {

    private final ErrorHttpDtoBuilder errorHttpDtoBuilder;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHttpDto> exceptionHandler(Exception e, WebRequest request) {
        log.error("Ошибка при выполнении запроса: ", e);
        var status = e instanceof IllegalArgumentException ? BAD_REQUEST : INTERNAL_SERVER_ERROR;
        var errorHttpDto = errorHttpDtoBuilder.build(e, status, request);
        return ResponseEntity.status(status).body(errorHttpDto);
    }

}
