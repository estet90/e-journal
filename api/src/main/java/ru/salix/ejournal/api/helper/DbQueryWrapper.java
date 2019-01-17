package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;
import ru.salix.ejournal.error.code.ExceptionCode;
import ru.salix.ejournal.error.exception.InvocationException;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInvocationException;

@NoArgsConstructor(access = PRIVATE)
public class DbQueryWrapper {

    public static <T> T execute(Supplier<T> query, ExceptionCode<InvocationException> code) {
        try {
            return query.get();
        } catch (DataAccessException e) {
            throw newInvocationException(e, resolve(), code);
        }
    }

    public static void execute(Runnable query, ExceptionCode<InvocationException> code) {
        try {
            query.run();
        } catch (DataAccessException e) {
            throw newInvocationException(e, resolve(), code);
        }
    }

}
