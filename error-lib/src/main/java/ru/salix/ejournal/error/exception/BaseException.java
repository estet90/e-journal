package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;
import ru.salix.ejournal.error.type.ExceptionType;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public abstract class BaseException extends RuntimeException {

    static final String OTHER_EXCEPTION_MESSAGE = "Other exception";
    static final String UNKNOWN_OPERATION_MESSAGE = "Unknown operation";

    private final String service;
    private final String operation;
    private final String type;
    private final String code;
    private final Object payload;
    private String originalCode;
    private String originalMessage;

    BaseException(
            String message,
            Throwable cause,
            String service,
            OperationCode operation,
            ExceptionType type,
            ExceptionCode code,
            Object payload
    ) {
        super(message, cause);
        this.service = service;
        this.operation = isNull(operation) ? null : operation.getCode();
        this.type = isNull(type) ? null : type.getCode();
        this.code = isNull(code) ? null : code.getCode();
        this.payload = payload;
    }

    public String getService() {
        return service;
    }

    public String getOperation() {
        return operation;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getFullErrorCode() {
        return format("%s-%s-%s%s", service, operation, type, code);
    }

    public Object getPayload() {
        return payload;
    }

    public String getOriginalCode() {
        return originalCode;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    public String getOriginalMessage() {
        return originalMessage;
    }

    public void setOriginalMessage(String originalMessage) {
        this.originalMessage = originalMessage;
    }

    @Override
    public String toString() {
        return getFullErrorCode();
    }
}
