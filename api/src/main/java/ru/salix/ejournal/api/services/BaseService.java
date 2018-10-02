package ru.salix.ejournal.api.services;

import lombok.RequiredArgsConstructor;
import ru.salix.ejournal.api.entities.BaseEntity;
import ru.salix.ejournal.api.repositories.BaseRepository;

import java.util.List;

@RequiredArgsConstructor
public class BaseService<E extends BaseEntity, T extends BaseRepository<E>> {

    protected final T repository;

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
