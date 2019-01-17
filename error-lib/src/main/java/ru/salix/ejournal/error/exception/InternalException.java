package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.operation.OperationCode;

import static ru.salix.ejournal.error.code.ExceptionCode.OTHER;
import static ru.salix.ejournal.error.type.ExceptionType.INTERNAL;

public class InternalException extends BaseException {

    InternalException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation
    ) {
        super(message, cause, service, operation, INTERNAL, () -> OTHER, null);
    }
}