package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.ExamMarkFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class ExamMarkSpecifications {

    public Specification<ExamMark> filterSpecification(ExamMarkFilterDto filter) {
        return (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var classJoin = simpleJoin(filter.getClassName(), className -> root.join(ExamMark_.pupil).join(Pupil_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), subject -> root.join(ExamMark_.exam).join(Exam_.subject));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(ExamMark_.id), id)),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(filter.getDatetimeFrom(), dateTime -> builder.greaterThanOrEqualTo(root.get(ExamMark_.datetime), dateTime)),
                    predicate(filter.getDatetimeTo(), dateTime -> builder.lessThanOrEqualTo(root.get(ExamMark_.datetime), dateTime)),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject()))
            );
        };
    }

    private ListJoin<Exam, Teacher> teacherJoin(ExamMarkFilterDto filter, Root<ExamMark> root) {
        return listJoin(
                () -> root.join(ExamMark_.exam).join(Exam_.teachers),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private Join<ExamMark, Pupil> pupilJoin(ExamMarkFilterDto filter, Root<ExamMark> root) {
        return join(
                () -> root.join(ExamMark_.pupil),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

}
