package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.helper.SpecificationHelper;
import ru.salix.ejournal.api.model.api.filter.TestFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class TestFilterSpecifications {

    public Specification<Test> filterSpecification(TestFilterDto filter) {
        return (Specification<Test>) (root, query, builder) -> {
            var schoolClassJoin = simpleJoin(filter.getClassName(),
                    schoolClass -> root.join(Test_.lesson).join(Lesson_.timetable).join(Timetable_.schoolClass));
            var subjectJoin = simpleJoin(filter.getSubject(), subject -> root.join(Test_.lesson).join(Lesson_.timetable).join(Timetable_.subject));
            var lessonJoin = lessonJoin(filter, root);
            return SpecificationHelper.where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Test_.id), id)),
                    predicate(schoolClassJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName()))),
                    predicate(schoolClassJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(filter.getDateFrom(), date -> builder.greaterThanOrEqualTo(lessonJoin.get(Lesson_.date), date)),
                    predicate(filter.getDateTo(), date -> builder.lessThanOrEqualTo(lessonJoin.get(Lesson_.date), date))
            );
        };
    }

    private Join<Test, Lesson> lessonJoin(TestFilterDto filter, Root<Test> root) {
        return join(
                () -> root.join(Test_.lesson),
                filter.getDateFrom(),
                filter.getDateTo()
        );
    }

}
