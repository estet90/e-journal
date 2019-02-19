package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.ExamFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class ExamSpecifications {

    public Specification<Exam> filterSpecification(ExamFilterDto filter) {
        return (root, query, builder) -> {
            var classJoin = simpleJoin(filter.getClassName(), value -> root.join(Exam_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), value -> root.join(Exam_.subject));
            var teacherJoin = teacherJoin(filter, root);
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Exam_.id), id)),
                    predicate(filter.getDatetimeFrom(), datetime -> builder.greaterThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeFrom())),
                    predicate(filter.getDatetimeTo(), datetime -> builder.lessThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeTo())),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic))
            );
        };
    }

    private ListJoin<Exam, Teacher> teacherJoin(ExamFilterDto filter, Root<Exam> root) {
        return listJoin(
                () -> root.join(Exam_.teachers),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

}
