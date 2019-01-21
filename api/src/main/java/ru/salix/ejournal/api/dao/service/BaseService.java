package ru.salix.ejournal.api.dao.service;

import org.springframework.data.jpa.domain.Specification;
import ru.salix.ejournal.api.dao.repository.BaseRepository;
import ru.salix.ejournal.api.entity.BaseEntity;

import java.util.List;
import java.util.function.Supplier;

import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

public class BaseService<E extends BaseEntity, T extends BaseRepository<E>> {

    protected final T repository;

    protected BaseService(T repository) {
        this.repository = repository;
    }

    E save(E entity) {
        return execute(() -> repository.save(entity), DB_EXCEPTION);
    }

    public Long saveAndReturnId(E entity) {
        return save(entity).getId();
    }

    public List<E> saveAll(List<E> entities) {
        return execute(() -> repository.saveAll(entities), DB_EXCEPTION);
    }

    public E update(E entity) {
        return execute(() -> repository.save(entity), DB_EXCEPTION);
    }

    public E findById(Long id) {
        return execute(() -> repository.findById(id).orElse(null), DB_EXCEPTION);
    }

    public List<E> findAll() {
        return execute((Supplier<List<E>>) repository::findAll, DB_EXCEPTION);
    }

    public List<E> filter(Specification<E> specification) {
        return execute(() -> repository.findAll(specification), DB_EXCEPTION);
    }

    public void delete(E entity) {
        execute(() -> repository.delete(entity), DB_EXCEPTION);
    }

    public void deleteById(Long id) {
        execute(() -> repository.deleteById(id), DB_EXCEPTION);
    }

}
