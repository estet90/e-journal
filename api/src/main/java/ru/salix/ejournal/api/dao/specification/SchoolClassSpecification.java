package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.SchoolClassFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class SchoolClassSpecification {

    public Specification<SchoolClass> filterSpecification(SchoolClassFilterDto filter) {
        return (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var subjectJoin = simpleJoin(filter.getSubject(), value -> root.join(SchoolClass_.timetables).join(Timetable_.subject));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(SchoolClass_.id), id)),
                    predicate(filter.getName(), join -> builder.equal(root.get(SchoolClass_.liter), liter(filter.getName()))),
                    predicate(filter.getName(), join -> builder.equal(root.get(SchoolClass_.number), number(filter.getName()))),
                    predicate(filter.getTeacherName(), name -> builder.equal(teacherJoin.get(Teacher_.name), name)),
                    predicate(filter.getTeacherSurname(), surname -> builder.equal(teacherJoin.get(Teacher_.surname), surname)),
                    predicate(filter.getTeacherPatronymic(), patronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), patronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject()))
            );
        };
    }

    private Join<SchoolClass, Teacher> teacherJoin(SchoolClassFilterDto filter, Root<SchoolClass> root) {
        return join(
                () -> root.join(SchoolClass_.teacher),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private ListJoin<SchoolClass, Pupil> pupilJoin(SchoolClassFilterDto filter, Root<SchoolClass> root) {
        return listJoin(
                () -> root.join(SchoolClass_.pupils),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

}
