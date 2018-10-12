package ru.salix.ejournal.api.dao.services;

import ru.salix.ejournal.api.dao.repositories.BaseRepository;
import ru.salix.ejournal.api.entities.BaseEntity;

import java.util.List;

public class BaseService<E extends BaseEntity, T extends BaseRepository<E>> {

    protected final T repository;

    protected BaseService(T repository) {
        this.repository = repository;
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public List<E> saveAll(List<E> entities) {
        return repository.saveAll(entities);
    }

    public E update(E entity) {
        return repository.save(entity);
    }

    public E findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
