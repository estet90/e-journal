package ru.salix.ejournal.api.builder.dto;

import ru.salix.ejournal.api.entity.BaseEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDtoBuilder<T, V extends BaseEntity> {

    public abstract T build(V entity);

    public List<T> buildList(List<V> entities) {
        return entities
                .stream()
                .map(this::build)
                .collect(toList());
    }

}
