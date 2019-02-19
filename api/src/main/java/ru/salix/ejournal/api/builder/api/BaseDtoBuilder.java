package ru.salix.ejournal.api.builder.api;

import ru.salix.ejournal.api.mapper.BaseMapper;
import ru.salix.ejournal.api.model.api.BaseDtoEntity;
import ru.salix.ejournal.api.model.dao.BaseEntity;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class BaseDtoBuilder<T extends BaseDtoEntity, V extends BaseEntity> {

    protected final BaseMapper<V, T> mapper;

    protected BaseDtoBuilder(BaseMapper<V, T> mapper) {
        this.mapper = mapper;
    }

    /**
     * метод предназначен для сборки соответствующей сущности без внешних связей
     *
     * @param entity DAO
     * @return T DTO
     */
    public T build(V entity) {
        return mapper.toDto(entity);
    }

    /**
     * метод предназначен для сборки соответствующей сущности с внешними связями
     *
     * @param entity DAO
     * @return T DTO
     */
    public T buildWithRelatedObjects(V entity) {
        return mapper.toDtoWithRelatedObjects(entity);
    }

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
