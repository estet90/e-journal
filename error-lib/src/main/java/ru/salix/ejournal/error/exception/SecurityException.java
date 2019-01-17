package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;

import static ru.salix.ejournal.error.type.ExceptionType.SECURITY;

public class SecurityException extends ValidationException {

    SecurityException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionCode<ValidationException> code,
            Object payload
    ) {
        super(message, cause, service, operation, SECURITY, code, payload);
    }
}
