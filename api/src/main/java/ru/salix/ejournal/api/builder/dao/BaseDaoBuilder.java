package ru.salix.ejournal.api.builder.dao;

import ru.salix.ejournal.api.mapper.BaseMapper;
import ru.salix.ejournal.api.model.api.BaseDtoEntity;
import ru.salix.ejournal.api.model.dao.BaseEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BaseDaoBuilder<T extends BaseEntity, V extends BaseDtoEntity> {

    protected final BaseMapper<T, V> mapper;

    protected BaseDaoBuilder(BaseMapper<T, V> mapper) {
        this.mapper = mapper;
    }

    /**
     * метод предназначен для сборки соответствующей сущности без внешних связей
     *
     * @param entity DTO
     * @return T DAO
     */
    public T build(V entity) {
        return mapper.fromDto(entity);
    }

    /**
     * метод предназначен для сборки соответствующей сущности с внешними связями
     *
     * @param entity DTO
     * @return T DAO
     */
    public T buildWithRelatedObjects(V entity) {
        return mapper.fromDtoWithRelatedObjects(entity);
    }

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

    /**
     * метод предназначен для сборки соответствующей сущности с внешними связями
     * идентификатор передаётся отдельно
     * может использоваться при обновлении
     *
     * @param dtoEntity DTO
     * @param id        идентификатор
     * @return T DAO
     */
    public T buildWithRelatedObjects(V dtoEntity, Long id) {
        var daoEntity = build(dtoEntity);
        daoEntity.setId(id);
        return daoEntity;
    }

}
