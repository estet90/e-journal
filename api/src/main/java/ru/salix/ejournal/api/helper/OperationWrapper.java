package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;
import ru.salix.ejournal.error.exception.BaseException;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInternalException;

@NoArgsConstructor(access = PRIVATE)
public class OperationWrapper {

    public static <T> T wrap(Supplier<T> action) {
        try {
            return action.get();
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw newInternalException(e, resolve());
        }
    }

    public static void wrap(Runnable action) {
        try {
            action.run();
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            throw newInternalException(e, resolve());
        }
    }

}
