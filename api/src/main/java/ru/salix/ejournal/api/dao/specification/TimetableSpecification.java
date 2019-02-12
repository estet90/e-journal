package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.TimetableFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class TimetableSpecification {

    public Specification<Timetable> filterSpecification(TimetableFilterDto filter) {
        return (Specification<Timetable>) (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var classJoin = ofNullable(filter.getClassName()).map(value -> root.join(Timetable_.schoolClass)).orElse(null);
            var subjectJoin = ofNullable(filter.getSubject()).map(value -> root.join(Timetable_.subject)).orElse(null);
            var lessonPeriodJoin = lessonPeriodJoin(filter, root);
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Timetable_.id), id)),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(filter.getLessonPeriodNumber(), number -> builder.equal(lessonPeriodJoin.get(LessonPeriod_.number), number)),
                    predicate(filter.getLessonPeriodShift(), shift -> builder.equal(lessonPeriodJoin.get(LessonPeriod_.shift), shift))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

    private Join<Timetable, Teacher> teacherJoin(TimetableFilterDto filter, Root<Timetable> root) {
        return join(
                () -> root.join(Timetable_.teacher),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private Join<Timetable, LessonPeriod> lessonPeriodJoin(TimetableFilterDto filter, Root<Timetable> root) {
        return join(
                () -> root.join(Timetable_.lessonPeriod),
                filter.getLessonPeriodNumber(),
                filter.getLessonPeriodShift()
        );
    }

    private ListJoin<SchoolClass, Pupil> pupilJoin(TimetableFilterDto filter, Root<Timetable> root) {
        return listJoin(
                () -> root.join(Timetable_.schoolClass).join(SchoolClass_.pupils),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

}
