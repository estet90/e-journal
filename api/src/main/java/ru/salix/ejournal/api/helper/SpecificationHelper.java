package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;

import javax.persistence.criteria.*;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SpecificationHelper {

    /**
     * формирование предусловия для блока WHERE
     * условие формируется только для ненулевого аргумента
     *
     * @param value    значение из сущности фильтра для проверки
     * @param function функция формирования предиката
     * @param <T>      тип
     * @return предусловие
     */
    public static <T> Predicate predicate(T value, Function<T, Predicate> function) {
        return ofNullable(value).map(function).orElse(null);
    }

    /**
     * извлечение литера из названия класса
     *
     * @param fullClassName название класса
     * @return литер
     */
    public static char liter(String fullClassName) {
        return fullClassName.split(" ")[1].charAt(0);
    }

    /**
     * извлечение номера из имени класса
     *
     * @param fullClassName название класса
     * @return номер
     */
    public static int number(String fullClassName) {
        return Integer.valueOf(fullClassName.split(" ")[0]);
    }

    /**
     * @param flag     параметр, проверяемый на null и истинность
     * @param function формирование join
     * @param <T>      тип связываемой сущности
     * @param <V>      тип связанной сущности
     * @return Join
     */
    public static <T, V> Join<T, V> flagJoin(Boolean flag, Function<Boolean, Join<T, V>> function) {
        return ofNullable(flag)
                .filter(flagValue -> flagValue)
                .map(function)
                .orElse(null);
    }

    /**
     * @param parameter параметр, проверяемый на null
     * @param function  формирование join
     * @param <M>       тип входного параметра
     * @param <T>       тип связываемой сущности
     * @param <V>       тип связанной сущности
     * @return Join
     */
    public static <M, T, V> Join<T, V> simpleJoin(M parameter, Function<M, Join<T, V>> function) {
        return ofNullable(parameter)
                .map(function)
                .orElse(null);
    }

    /**
     * join для одиночного параметра без вложенности
     *
     * @param join   целевой метод
     * @param fields поля, которые проверяются на null перед тем, как выполнить join
     * @param <T>    тип связываемой сущности
     * @param <V>    тип связанной сущности
     * @return Join
     */
    public static <T, V> Join<T, V> join(Supplier<Join<T, V>> join, Object... fields) {
        return Stream
                .of(fields)
                .filter(Objects::nonNull)
                .findAny()
                .map(value -> join.get())
                .orElse(null);
    }

    /**
     * join для множественного параметра без вложенности
     *
     * @param join   целевой метод
     * @param fields поля, которые проверяются на null перед тем, как выполнить join
     * @param <T>    тип связываемой сущности
     * @param <V>    тип связанной сущности
     * @return ListJoin
     */
    public static <T, V> ListJoin<T, V> listJoin(Supplier<ListJoin<T, V>> join, Object... fields) {
        return Stream
                .of(fields)
                .filter(Objects::nonNull)
                .findAny()
                .map(value -> join.get())
                .orElse(null);
    }

    /**
     * @param query     запрос
     * @param builder   CriteriaBuilder
     * @param predicate список условий
     * @return where
     */
    public static Predicate where(CriteriaQuery query, CriteriaBuilder builder, Predicate... predicate) {
        return query.where(expression(builder, predicate)).getGroupRestriction();
    }

    private static Expression<Boolean> expression(CriteriaBuilder builder, Predicate... predicate) {
        return builder.and(Stream.of(predicate)
                .filter(Objects::nonNull)
                .toArray(Predicate[]::new)
        );
    }

}
