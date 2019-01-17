package ru.salix.ejournal.api.constant;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ThreadContextField {

    public static String OPERATION_NAME = "OperationName";
    public static String TRACE_ID = "TraceId";

}
