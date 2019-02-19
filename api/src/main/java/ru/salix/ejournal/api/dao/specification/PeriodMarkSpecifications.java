package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.PeriodMarkFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class PeriodMarkSpecifications {

    public Specification<PeriodMark> filterSpecification(PeriodMarkFilterDto filter) {
        return (Specification<PeriodMark>) (root, query, builder) -> {
            var teacherJoin = teacherJoin(filter, root);
            var pupilJoin = pupilJoin(filter, root);
            var periodJoin = periodJoin(filter, root);
            var periodTypeJoin = simpleJoin(filter.getPeriodTypeName(), periodTypeName -> root.join(PeriodMark_.period).join(Period_.periodType));
            var classJoin = simpleJoin(filter.getClassName(), className -> root.join(PeriodMark_.pupil).join(Pupil_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), subject -> root.join(PeriodMark_.subject));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(PeriodMark_.id), id)),
                    predicate(filter.getTeacherName(), teacherName -> builder.equal(teacherJoin.get(Teacher_.name), teacherName)),
                    predicate(filter.getTeacherSurname(), teacherSurname -> builder.equal(teacherJoin.get(Teacher_.surname), teacherSurname)),
                    predicate(filter.getTeacherPatronymic(), teacherPatronymic -> builder.equal(teacherJoin.get(Teacher_.patronymic), teacherPatronymic)),
                    predicate(filter.getPupilName(), name -> builder.equal(pupilJoin.get(Pupil_.name), name)),
                    predicate(filter.getPupilSurname(), surname -> builder.equal(pupilJoin.get(Pupil_.surname), surname)),
                    predicate(filter.getPupilPatronymic(), patronymic -> builder.equal(pupilJoin.get(Pupil_.patronymic), patronymic)),
                    predicate(filter.getDateFrom(), dateTime -> builder.greaterThanOrEqualTo(periodJoin.get(Period_.dateStart), dateTime)),
                    predicate(filter.getDateTo(), dateTime -> builder.lessThanOrEqualTo(periodJoin.get(Period_.dateEnd), dateTime)),
                    predicate(periodTypeJoin, join -> builder.equal(join.get(PeriodType_.name), filter.getPeriodTypeName())),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject()))
            );
        };
    }

    private Join<Timetable, Teacher> teacherJoin(PeriodMarkFilterDto filter, Root<PeriodMark> root) {
        return join(
                () -> root.join(PeriodMark_.period).join(Period_.timetables).join(Timetable_.teacher),
                filter.getTeacherName(),
                filter.getTeacherSurname(),
                filter.getTeacherPatronymic()
        );
    }

    private Join<PeriodMark, Pupil> pupilJoin(PeriodMarkFilterDto filter, Root<PeriodMark> root) {
        return join(
                () -> root.join(PeriodMark_.pupil),
                filter.getPupilName(),
                filter.getPupilSurname(),
                filter.getPupilPatronymic()
        );
    }

    private Join<PeriodMark, Period> periodJoin(PeriodMarkFilterDto filter, Root<PeriodMark> root) {
        return join(
                () -> root.join(PeriodMark_.period),
                filter.getDateFrom(),
                filter.getDateTo()
        );
    }

}
