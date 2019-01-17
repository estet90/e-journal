package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;
import ru.salix.ejournal.error.type.ExceptionType;

import static ru.salix.ejournal.error.type.ExceptionType.VALIDATION;

public class ValidationException extends DetailedException {

    ValidationException(Throwable cause, String service) {
        this(UNKNOWN_OPERATION_MESSAGE, cause, service, () -> OperationCode.OTHER, () -> ExceptionCode.OTHER, null);
    }

    ValidationException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionCode<ValidationException> code,
            Object payload
    ) {
        this(message, cause, service, operation, VALIDATION, code, payload);
    }

    ValidationException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionType type,
            ExceptionCode<ValidationException> code,
            Object payload
    ) {
        super(message, cause, service, operation, type, code, payload);
    }
}
