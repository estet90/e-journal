package ru.salix.ejournal.api.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.exception.InvocationException;

@RequiredArgsConstructor
@Getter
public enum InvocationExceptionCode implements ExceptionCode<InvocationException> {

    DB_EXCEPTION("01"),
    NOT_FOUND_IN_DB_EXCEPTION("02");

    private final String code;

}
