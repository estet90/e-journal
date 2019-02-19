package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.TeacherFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class TeacherSpecifications {

    public Specification<Teacher> filterSpecification(TeacherFilterDto filter) {
        return (root, query, builder) -> {
            var subjectJoin = simpleJoin(filter.getSubject(), value -> root.join(Teacher_.subjects));
            var ownClassJoin = simpleJoin(filter.getOwnClassName(), value -> root.join(Teacher_.classes));
            var relatedClassJoin = simpleJoin(filter.getRelatedClassName(), value -> root.join(Teacher_.timetables).join(Timetable_.schoolClass));
            var examJoin = examJoin(filter, root);
            var examClassJoin = simpleJoin(filter.getExamClassName(), className -> root.join(Teacher_.exams).join(Exam_.schoolClass));
            var examSubjectJoin = simpleJoin(filter.getExamSubject(), subject -> root.join(Teacher_.exams).join(Exam_.subject));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Teacher_.id), id)),
                    predicate(filter.getName(), name -> builder.equal(root.get(Teacher_.name), name)),
                    predicate(filter.getSurname(), surname -> builder.equal(root.get(Teacher_.surname), surname)),
                    predicate(filter.getPatronymic(), patronymic -> builder.equal(root.get(Teacher_.patronymic), patronymic)),
                    predicate(filter.getDescription(), description -> builder.equal(root.get(Teacher_.description), description)),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(ownClassJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getOwnClassName()))),
                    predicate(ownClassJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getOwnClassName()))),
                    predicate(relatedClassJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getRelatedClassName()))),
                    predicate(relatedClassJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getRelatedClassName()))),
                    predicate(examClassJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getExamClassName()))),
                    predicate(examClassJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getExamClassName()))),
                    predicate(examSubjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getExamSubject())),
                    predicate(filter.getExamDatetimeFrom(), dateTime -> builder.greaterThanOrEqualTo(examJoin.get(Exam_.datetime), filter.getExamDatetimeFrom())),
                    predicate(filter.getExamDatetimeTo(), dateTime -> builder.lessThanOrEqualTo(examJoin.get(Exam_.datetime), filter.getExamDatetimeTo()))
            );
        };
    }

    private ListJoin<Teacher, Exam> examJoin(TeacherFilterDto filter, Root<Teacher> root) {
        return listJoin(
                () -> root.join(Teacher_.exams),
                filter.getExamDatetimeFrom(),
                filter.getExamDatetimeTo()
        );
    }

}
