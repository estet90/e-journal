package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.LessonMarkFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class LessonMarkSpecifications {

    public Specification<LessonMark> filterSpecification(LessonMarkFilterDto filter) {
        return (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var classJoin = simpleJoin(filter.getClassName(), className -> root.join(LessonMark_.pupil).join(Pupil_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), subject -> root.join(LessonMark_.lesson).join(Lesson_.timetable).join(Timetable_.subject));
            var homeworkJoin = flagJoin(filter.getHomeworkMark(), flag -> root.join(LessonMark_.homework));
            var testJoin = flagJoin(filter.getTestMark(), flag -> root.join(LessonMark_.test));
            var lessonJoin = flagJoin(filter.getLessonMark(), flag -> root.join(LessonMark_.lesson));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(LessonMark_.id), id)),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(filter.getDatetimeFrom(), dateTime -> builder.greaterThanOrEqualTo(root.get(LessonMark_.datetime), dateTime)),
                    predicate(filter.getDatetimeTo(), dateTime -> builder.lessThanOrEqualTo(root.get(LessonMark_.datetime), dateTime)),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(homeworkJoin, join -> builder.isNotNull(join.get(Homework_.id))),
                    predicate(testJoin, join -> builder.isNotNull(join.get(Test_.id))),
                    predicate(lessonJoin, join -> builder.isNotNull(join.get(Lesson_.id)))
            );
        };
    }

    private Join<Timetable, Teacher> teacherJoin(LessonMarkFilterDto filter, Root<LessonMark> root) {
        return join(
                () -> root.join(LessonMark_.lesson).join(Lesson_.timetable).join(Timetable_.teacher),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private Join<LessonMark, Pupil> pupilJoin(LessonMarkFilterDto filter, Root<LessonMark> root) {
        return join(
                () -> root.join(LessonMark_.pupil),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

}
