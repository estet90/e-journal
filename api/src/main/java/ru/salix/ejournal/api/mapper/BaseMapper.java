package ru.salix.ejournal.api.mapper;

import org.mapstruct.Qualifier;
import ru.salix.ejournal.api.model.api.BaseDtoEntity;
import ru.salix.ejournal.api.model.dao.BaseEntity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<T extends BaseEntity, V extends BaseDtoEntity> {

    T fromDto(V entity);

    V toDto(T entity);

    default T fromDtoWithRelatedObjects(V entity) {
        return fromDto(entity);
    }

    default V toDtoWithRelatedObjects(T entity) {
        return toDto(entity);
    }

    @FromDtoList
    default List<T> fromDtoList(List<V> entities) {
        return entities.stream().map(this::fromDto).collect(Collectors.toList());
    }

    @ToDtoList
    default List<V> toDtoList(List<T> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface FromDtoList {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface ToDtoList {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface FromDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface ToDto {
    }

}
