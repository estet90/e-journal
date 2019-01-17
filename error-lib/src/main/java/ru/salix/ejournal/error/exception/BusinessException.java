package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;

import static ru.salix.ejournal.error.type.ExceptionType.BUSINESS;

public class BusinessException extends DetailedException {

    BusinessException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionCode<BusinessException> code,
            Object payload
    ) {
        super(message, cause, service, operation, BUSINESS, code, payload);
    }
}
