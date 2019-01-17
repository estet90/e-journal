package ru.salix.ejournal.error.exception;

import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.operation.OperationCode;
import ru.salix.ejournal.error.type.ExceptionType;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.Objects.isNull;
import static ru.salix.ejournal.error.type.ExceptionType.BUSINESS;

public class ExceptionFactory {

    private static final String DEFAULT_MESSAGE = "Message not defined";

    private static String serviceCode;

    public ExceptionFactory(String serviceCode) {
        ExceptionFactory.serviceCode = serviceCode;
    }

    public static BusinessException newBusinessException(
            OperationCode operationCode,
            ExceptionCode<BusinessException> exceptionCode,
            Object payload,
            String... args
    ) {
        String message = prepareMessage(operationCode, BUSINESS, exceptionCode, args);
        return new BusinessException(message, null, serviceCode, operationCode, exceptionCode, payload);
    }

    public static BusinessException newBusinessException(
            OperationCode operationCode,
            ExceptionCode<BusinessException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.BUSINESS, exceptionCode, args);
        return new BusinessException(message, null, serviceCode, operationCode, exceptionCode, null);
    }

    public static BusinessException newBusinessException(
            Throwable cause,
            OperationCode operationCode,
            ExceptionCode<BusinessException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.BUSINESS, exceptionCode, args);
        return new BusinessException(message, cause, serviceCode, operationCode, exceptionCode, null);
    }

    public static InvocationException newInvocationException(
            OperationCode operation,
            ExceptionCode<InvocationException> exceptionCode,
            Object payload,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.INVOCATION, exceptionCode, args);
        return new InvocationException(message, null, serviceCode, operation, exceptionCode, payload);
    }

    public static InvocationException newInvocationException(
            OperationCode operation,
            ExceptionCode<InvocationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.INVOCATION, exceptionCode, args);
        return new InvocationException(message, null, serviceCode, operation, exceptionCode, null);
    }

    public static InvocationException newInvocationException(
            Throwable cause,
            OperationCode operationCode,
            ExceptionCode<InvocationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.INVOCATION, exceptionCode, args);
        return new InvocationException(message, cause, serviceCode, operationCode, exceptionCode, null);
    }

    public static InvocationException newInvocationException(RetryableException exception) {
        return new InvocationException(
                exception.getMessage(),
                exception.getCause(),
                exception.getService(),
                exception::getOperation,
                ExceptionType.INVOCATION,
                exception::getCode,
                exception.getPayload());
    }

    public static RetryableException newRetryableException(
            OperationCode operation,
            ExceptionCode<InvocationException> exceptionCode,
            Object payload,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.INVOCATION, exceptionCode, args);
        return new RetryableException(message, null, serviceCode, operation, exceptionCode, payload);
    }

    public static RetryableException newRetryableException(
            OperationCode operation,
            ExceptionCode<InvocationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.INVOCATION, exceptionCode, args);
        return new RetryableException(message, null, serviceCode, operation, exceptionCode, null);
    }

    public static RetryableException newRetryableException(
            Throwable cause,
            OperationCode operationCode,
            ExceptionCode<InvocationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.INVOCATION, exceptionCode, args);
        return new RetryableException(message, cause, serviceCode, operationCode, exceptionCode, null);
    }

    public static ValidationException newValidationException(
            OperationCode operation,
            ExceptionCode<ValidationException> exceptionCode,
            Object payload,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.VALIDATION, exceptionCode, args);
        return new ValidationException(message, null, serviceCode, operation, exceptionCode, payload);
    }

    public static ValidationException newValidationException(
            OperationCode operation,
            ExceptionCode<ValidationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.VALIDATION, exceptionCode, args);
        return new ValidationException(message, null, serviceCode, operation, exceptionCode, null);
    }

    public static ValidationException newValidationException(
            Throwable cause,
            OperationCode operationCode,
            ExceptionCode<ValidationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.VALIDATION, exceptionCode, args);
        return new ValidationException(message, cause, serviceCode, operationCode, exceptionCode, null);
    }

    public static SecurityException newSecurityException(
            OperationCode operation,
            ExceptionCode<ValidationException> exceptionCode,
            Object payload,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.SECURITY, exceptionCode, args);
        return new SecurityException(message, null, serviceCode, operation, exceptionCode, payload);
    }

    public static SecurityException newSecurityException(
            OperationCode operation,
            ExceptionCode<ValidationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operation, ExceptionType.SECURITY, exceptionCode, args);
        return new SecurityException(message, null, serviceCode, operation, exceptionCode, null);
    }

    public static SecurityException newSecurityException(
            Throwable cause,
            OperationCode operationCode,
            ExceptionCode<ValidationException> exceptionCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.SECURITY, exceptionCode, args);
        return new SecurityException(message, cause, serviceCode, operationCode, exceptionCode, null);
    }

    public static ValidationException newUnknownOperationException(Throwable cause) {
        return new ValidationException(cause, serviceCode);
    }

    public static InternalException newInternalException(
            Throwable cause,
            OperationCode operationCode,
            String... args
    ) {
        String message = prepareMessage(operationCode, ExceptionType.INTERNAL, () -> ExceptionCode.OTHER, args);
        return new InternalException(message, cause, serviceCode, operationCode);
    }

    private static Class<? extends BaseException> resolveBaseExceptionClass(Throwable throwable) {
        if (throwable instanceof ConnectException || throwable instanceof SocketTimeoutException) {
            return RetryableException.class;
        }
        if (Objects.nonNull(throwable)) {
            return resolveBaseExceptionClass(throwable.getCause());
        }
        return InvocationException.class;
    }

    private static String prepareMessage(OperationCode operationCode, ExceptionType exceptionType, ExceptionCode exceptionCode, String... args) {
        //TODO: придумать реализацию
        return appendArguments(DEFAULT_MESSAGE, args);
    }

    private static String findMessage(OperationCode operationCode, ExceptionType exceptionType, ExceptionCode exceptionCode) {
        //TODO: придумать реализацию
        return null;
    }

    private static String appendArguments(String message, String... args) {
        return message + stream(args).map(o -> ", '" + o + '\'').reduce(String::concat).orElse("");
    }
}
