package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;
import ru.salix.ejournal.error.type.ExceptionType;

abstract class DetailedException extends BaseException {

    DetailedException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionType type,
            ExceptionCode<? extends DetailedException> code,
            Object payload
    ) {
        super(message, cause, service, operation, type, code, payload);
    }
}
