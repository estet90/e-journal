package ru.salix.ejournal.api.helper;

import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SpecificationHelper {

    public static <T> Predicate predicate(T value, Function<T, Predicate> function) {
        return ofNullable(value).map(function).orElse(null);
    }

    public static char liter(String fullClassName) {
        return fullClassName.split(" ")[1].charAt(0);
    }

    public static int number(String fullClassName) {
        return Integer.valueOf(fullClassName.split(" ")[0]);
    }

    public static Expression<Boolean> expression(CriteriaBuilder builder, Predicate... predicate) {
        return builder.and(Stream.of(predicate).filter(Objects::nonNull).toArray(Predicate[]::new));
    }

}
