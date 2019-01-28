package ru.salix.ejournal.api.builder.api;

import ru.salix.ejournal.api.model.api.BaseDtoEntity;
import ru.salix.ejournal.api.model.dao.BaseEntity;

import java.util.List;
import java.util.function.Supplier;

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

    /**
     * получение списка сущностей без связей
     *
     * @param supplier получение списка DAO
     * @return List<T> список DTO
     */
    public List<T> buildList(Supplier<List<V>> supplier) {
        return buildList(supplier.get());
    }

}
