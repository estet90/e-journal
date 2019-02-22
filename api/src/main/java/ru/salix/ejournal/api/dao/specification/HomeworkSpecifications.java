package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.HomeworkFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class HomeworkSpecifications {

    public Specification<Homework> filterSpecification(HomeworkFilterDto filter) {
        return (Specification<Homework>) (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var lessonReceiveJoin = lessonReceiveJoin(filter, root);
            var lessonCompleteJoin = lessonCompleteJoin(filter, root);
            var classJoin = simpleJoin(filter.getClassName(), className -> root.join(Homework_.lessonReceive).join(Lesson_.timetable).join(Timetable_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), subject -> root.join(Homework_.lessonReceive).join(Lesson_.timetable).join(Timetable_.subject));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Homework_.id), id)),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(filter.getDateReceiveFrom(), date -> builder.greaterThanOrEqualTo(lessonReceiveJoin.get(Lesson_.date), date)),
                    predicate(filter.getDateReceiveTo(), date -> builder.lessThanOrEqualTo(lessonReceiveJoin.get(Lesson_.date), date)),
                    predicate(filter.getDateCompleteFrom(), date -> builder.greaterThanOrEqualTo(lessonCompleteJoin.get(Lesson_.date), date)),
                    predicate(filter.getDateCompleteTo(), date -> builder.lessThanOrEqualTo(lessonCompleteJoin.get(Lesson_.date), date)),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject()))
            );
        };
    }

    private Join<Timetable, Teacher> teacherJoin(HomeworkFilterDto filter, Root<Homework> root) {
        return join(
                () -> root.join(Homework_.lessonReceive).join(Lesson_.timetable).join(Timetable_.teacher),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private ListJoin<SchoolClass, Pupil> pupilJoin(HomeworkFilterDto filter, Root<Homework> root) {
        return listJoin(
                () -> root.join(Homework_.lessonReceive).join(Lesson_.timetable).join(Timetable_.schoolClass).join(SchoolClass_.pupils),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

    private Join<Homework, Lesson> lessonReceiveJoin(HomeworkFilterDto filter, Root<Homework> root) {
        return join(
                () -> root.join(Homework_.lessonReceive),
                filter.getDateReceiveFrom(),
                filter.getDateReceiveTo()
        );
    }

    private Join<Homework, Lesson> lessonCompleteJoin(HomeworkFilterDto filter, Root<Homework> root) {
        return join(
                () -> root.join(Homework_.lessonComplete),
                filter.getDateCompleteFrom(),
                filter.getDateCompleteTo()
        );
    }

}
