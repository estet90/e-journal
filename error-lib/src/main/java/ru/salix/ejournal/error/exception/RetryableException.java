package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;

import static ru.salix.ejournal.error.type.ExceptionType.RETRYABLE;

public class RetryableException extends InvocationException {

    RetryableException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionCode<InvocationException> code,
            Object payload
    ) {
        super(message, cause, service, operation, RETRYABLE, code, payload);
    }
}
