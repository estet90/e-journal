package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;

import javax.persistence.criteria.*;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SpecificationHelper {

    /**
     * формирование предусловия для блока WHERE
     * условие формируется только для ненулевого аргумента
     *
     * @param value значение из сущности фильтра для проверки
     * @param function функция формирования предиката
     * @param <T> тип
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

    public static Expression<Boolean> expression(CriteriaBuilder builder, Predicate... predicate) {
        return builder.and(Stream.of(predicate).filter(Objects::nonNull).toArray(Predicate[]::new));
    }

    /**
     * join для одиночного параметра без вложенности
     *
     * @param root передаётся из сигнатуры метода
     * @param attribute атрибут, используемый для связи с нужной сущностью
     * @param fields поля, которые проверяются на null перед тем, как выполнить join
     * @param <T> тип связываемой сущности
     * @param <V> тип связанной сущности
     * @return Join
     */
    public static <T, V> Join<T, V> join(Root<T> root, SingularAttribute<T, V> attribute, Object... fields) {
        return Stream
                .of(fields)
                .filter(Objects::nonNull)
                .findAny()
                .map(value -> root.join(attribute))
                .orElse(null);
    }

    /**
     * join для списка
     *
     * @param root передаётся из сигнатуры метода
     * @param attribute атрибут, используемый для связи с нужной сущностью
     * @param fields поля, которые проверяются на null перед тем, как выполнить join
     * @param <T> тип связываемой сущности
     * @param <V> тип связанной сущности
     * @return ListJoin
     */
    public static <T, V> ListJoin<T, V> listJoin(Root<T> root, ListAttribute<T, V> attribute, Object... fields) {
        return Stream
                .of(fields)
                .filter(Objects::nonNull)
                .findAny()
                .map(value -> root.join(attribute))
                .orElse(null);
    }

}
