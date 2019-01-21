package ru.salix.ejournal.api.dao.specification;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.SubjectFilterDto;
import ru.salix.ejournal.api.entity.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class SubjectSpecifications {

    public Specification<Subject> filterSpecification(SubjectFilterDto filter) {
        return (Specification<Subject>) (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var classJoinOptional = classJoinOptional(filter, root);
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Subject_.id), id)),
                    predicate(filter.getName(), name -> builder.equal(root.get(Subject_.name), name)),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName())))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

    private ListJoin<Subject, Teacher> teacherJoin(SubjectFilterDto filter, Root<Subject> root) {
        return Stream
                .of(
                        filter.getTeacherName(),
                        filter.getTeacherSurname(),
                        filter.getTeacherPatronymic()
                )
                .filter(Objects::nonNull)
                .findAny()
                .map(value -> root.join(Subject_.teachers))
                .orElse(null);
    }

    private Optional<Join<Timetable, SchoolClass>> classJoinOptional(SubjectFilterDto filter, Root<Subject> root) {
        return ofNullable(filter.getClassName())
                .map(value -> root.join(Subject_.teachers)
                        .join(Teacher_.timetables)
                        .join(Timetable_.schoolClass)
                );
    }

}
