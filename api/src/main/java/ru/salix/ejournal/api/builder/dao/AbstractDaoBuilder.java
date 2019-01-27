package ru.salix.ejournal.api.builder.dao;

import ru.salix.ejournal.api.controller.dto.BaseDtoEntity;
import ru.salix.ejournal.api.entity.BaseEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AbstractDaoBuilder<T extends BaseEntity, V extends BaseDtoEntity> {

    /**
     * метод предназначен для сборки соответствующей сущности без внешних связей
     *
     * @param entity DTO
     * @return T DAO
     */
    public abstract T build(V entity);

    /**
     * получение списка сущностей без связей
     *
     * @param dtoEntities список DTO
     * @return List<T> список DAO
     */
    public List<T> buildList(List<V> dtoEntities) {
        return dtoEntities
                .stream()
                .map(this::build)
                .collect(toList());
    }

    /**
     * метод предназначен для сборки соответствующей сущности без внешних связей
     * идентификатор передаётся отдельно
     * может использоваться при обновлении
     *
     * @param dtoEntity DTO
     * @param id        идентификатор
     * @return T DAO
     */
    public T build(V dtoEntity, Long id) {
        var daoEntity = build(dtoEntity);
        daoEntity.setId(id);
        return daoEntity;
    }

}
