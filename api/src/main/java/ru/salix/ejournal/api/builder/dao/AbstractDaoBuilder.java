package ru.salix.ejournal.api.builder.dao;

import ru.salix.ejournal.api.entity.BaseEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDaoBuilder<T extends BaseEntity, V> {

    public abstract T build(V entity);

    public List<T> buildList(List<V> dtoEntities) {
        return dtoEntities
                .stream()
                .map(this::build)
                .collect(toList());
    }

    public T build(V dtoEntity, Long id) {
        var daoEntity = build(dtoEntity);
        daoEntity.setId(id);
        return daoEntity;
    }

}
