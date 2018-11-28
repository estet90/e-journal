package ru.salix.ejournal.api.dao.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.salix.ejournal.api.controllers.dto.TeacherFilterDto;
import ru.salix.ejournal.api.entities.*;

import javax.persistence.criteria.Predicate;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class TeacherSpecifications {

    public static Specification<Teacher> filterSpecification(TeacherFilterDto filter) {
        return (root, query, builder) -> {
            var subjectJoinOptional = ofNullable(filter.getSubject()).map(value -> root.join(Teacher_.subjects));
            var ownClassJoinOptional = ofNullable(filter.getOwnClassName()).map(value -> root.join(Teacher_.classes));
            var relatedClassJoinOptional = ofNullable(filter.getRelatedClassName())
                    .map(value -> root.join(Teacher_.timetables).join(Timetable_.schoolClass));
            var conditions = builder
                    .and(Stream
                            .of(
                                    predicate(filter.getId(), id -> builder.equal(root.get(Teacher_.id), id)),
                                    predicate(filter.getName(), name -> builder.equal(root.get(Teacher_.name), name)),
                                    predicate(filter.getSurname(), surname -> builder.equal(root.get(Teacher_.surname), surname)),
                                    predicate(filter.getPatronymic(), patronymic -> builder.equal(root.get(Teacher_.patronymic), patronymic)),
                                    predicate(filter.getDescription(), description -> builder.equal(root.get(Teacher_.description), description)),
                                    predicate(subjectJoinOptional.orElse(null), join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                                    predicate(ownClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number),
                                            Integer.valueOf(filter.getOwnClassName().split(" ")[0]))),
                                    predicate(ownClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter),
                                            filter.getOwnClassName().split(" ")[1].charAt(0))),
                                    predicate(relatedClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number),
                                            Integer.valueOf(filter.getRelatedClassName().split(" ")[0]))),
                                    predicate(relatedClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter),
                                            filter.getRelatedClassName().split(" ")[1].charAt(0)))
                            )
                            .filter(Objects::nonNull)
                            .toArray(Predicate[]::new)
                    );
            return query.where(conditions).getGroupRestriction();
        };
    }

    private static <T> Predicate predicate(T value, Function<T, Predicate> function) {
        return ofNullable(value).map(function).orElse(null);
    }

}
