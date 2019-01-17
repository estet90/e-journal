package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.ThreadContext;
import ru.salix.ejournal.api.error.operation.ModuleOperationCode;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;
import static ru.salix.ejournal.api.constant.ThreadContextField.OPERATION_NAME;

@NoArgsConstructor(access = PRIVATE)
public class ControllerWrapper {

    public static <T> T fillOperationCode(Supplier<T> action, ModuleOperationCode operationCode) {
        ThreadContext.put(OPERATION_NAME, operationCode.getName());
        return action.get();
    }

}
