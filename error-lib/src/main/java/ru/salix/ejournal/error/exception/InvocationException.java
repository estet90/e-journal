package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;
import ru.salix.ejournal.error.type.ExceptionType;

import static ru.salix.ejournal.error.type.ExceptionType.INVOCATION;

public class InvocationException extends DetailedException {

    InvocationException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionCode<InvocationException> code,
            Object payload
    ) {
        this(message, cause, service, operation, INVOCATION, code, payload);
    }

    InvocationException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionType type,
            ExceptionCode<InvocationException> code,
            Object payload
    ) {
        super(message, cause, service, operation, type, code, payload);
    }
}
