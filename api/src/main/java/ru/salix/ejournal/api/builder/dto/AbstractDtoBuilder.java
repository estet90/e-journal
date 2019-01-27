package ru.salix.ejournal.api.builder.dto;

import ru.salix.ejournal.api.controller.dto.BaseDtoEntity;
import ru.salix.ejournal.api.entity.BaseEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDtoBuilder<T extends BaseDtoEntity, V extends BaseEntity> {

    /**
     * метод предназначен для сборки соответствующей сущности без внешних связей
     *
     * @param entity DAO
     * @return T DTO
     */
    public abstract T build(V entity);

    /**
     * метод предназначен для сборки соответствующей сущности с внешними связями
     *
     * @param entity DAO
     * @return T DTO
     */
    public abstract T buildWithRelatedObjects(V entity);

    /**
     * получение списка сущностей без связей
     *
     * @param entities список DAO
     * @return List<T> список DTO
     */
    public List<T> buildList(List<V> entities) {
        return entities
                .stream()
                .map(this::build)
                .collect(toList());
    }

}
