package ru.salix.ejournal.api.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.exception.ValidationException;

@RequiredArgsConstructor
public enum ValidationExceptionCode implements ExceptionCode<ValidationException> {

    VALIDATE_BY_PATTERN_EXCEPTION("01");

    @Getter
    private final String code;

}
