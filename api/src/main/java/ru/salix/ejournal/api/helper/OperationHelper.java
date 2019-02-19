package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;
import ru.salix.ejournal.api.dao.repository.BaseRepository;
import ru.salix.ejournal.api.dao.service.BaseService;
import ru.salix.ejournal.api.model.api.BaseDtoEntity;
import ru.salix.ejournal.api.model.dao.BaseEntity;
import ru.salix.ejournal.error.exception.BaseException;

import java.util.function.Supplier;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;
import static ru.salix.ejournal.api.error.operation.ModuleOperationCode.resolve;
import static ru.salix.ejournal.api.helper.ExceptionHelper.notFoundInDbException;
import static ru.salix.ejournal.error.exception.ExceptionFactory.newInternalException;

@NoArgsConstructor(access = PRIVATE)
public class OperationHelper {

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

    public static <T extends BaseDtoEntity, V extends BaseEntity> void checkField(
            T field,
            BaseService<V, ? extends BaseRepository<V>> service,
            String message
    ) {
        ofNullable(field)
                .map(T::getId)
                .map(service::findById)
                .orElseThrow(() -> notFoundInDbException(message));
    }


}
