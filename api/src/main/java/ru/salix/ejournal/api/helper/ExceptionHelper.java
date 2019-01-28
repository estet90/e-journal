package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;
import ru.salix.ejournal.error.exception.InvocationException;

import static lombok.AccessLevel.PRIVATE;
import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.ALREADY_EXISTS_IN_DB_EXCEPTION;
import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.NOT_FOUND_IN_DB_EXCEPTION;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInvocationException;

@NoArgsConstructor(access = PRIVATE)
public class ExceptionHelper {

    public static InvocationException notFoundInDbException(String message) {
        return newInvocationException(resolve(), NOT_FOUND_IN_DB_EXCEPTION, message);
    }

    public static InvocationException alreadyExistsInDbException(String message) {
        return newInvocationException(resolve(), ALREADY_EXISTS_IN_DB_EXCEPTION, message);
    }

}
