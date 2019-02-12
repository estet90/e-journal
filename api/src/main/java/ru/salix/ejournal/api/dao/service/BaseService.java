package ru.salix.ejournal.api.dao.service;

import org.springframework.data.jpa.domain.Specification;
import ru.salix.ejournal.api.dao.repository.BaseRepository;
import ru.salix.ejournal.api.model.dao.BaseEntity;

import java.util.List;
import java.util.function.Supplier;

import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

public class BaseService<E extends BaseEntity, T extends BaseRepository<E>> {

    protected final T repository;

    protected BaseService(T repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return execute(() -> repository.save(entity), DB_EXCEPTION);
    }

    public Long saveAndReturnId(E entity) {
        return save(entity).getId();
    }

    public E findById(Long id) {
        return execute(() -> repository.findById(id).orElse(null), DB_EXCEPTION);
    }

    public List<E> findAll() {
        return execute((Supplier<List<E>>) repository::findAll, DB_EXCEPTION);
    }

    public void deleteById(Long id) {
        execute(() -> repository.deleteById(id), DB_EXCEPTION);
    }

    //использовать только внутри других сервисов
    protected List<E> filter(Specification<E> specification) {
        return execute(() -> repository.findAll(specification), DB_EXCEPTION);
    }

}
