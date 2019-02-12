package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.ExamFilterDto;
import ru.salix.ejournal.api.model.dao.Exam;
import ru.salix.ejournal.api.model.dao.Exam_;
import ru.salix.ejournal.api.model.dao.SchoolClass_;
import ru.salix.ejournal.api.model.dao.Subject_;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class ExamSpecifications {

    public Specification<Exam> filterSpecification(ExamFilterDto filter) {
        return (Specification<Exam>) (root, query, builder) -> {
            var classJoin = ofNullable(filter.getClassName()).map(value -> root.join(Exam_.schoolClass)).orElse(null);
            var subjectJoin = ofNullable(filter.getSubject()).map(value -> root.join(Exam_.subject)).orElse(null);
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Exam_.id), id)),
                    predicate(filter.getDatetimeFrom(), datetime -> builder.greaterThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeFrom())),
                    predicate(filter.getDatetimeTo(), datetime -> builder.lessThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeTo())),
                    predicate(subjectJoin, join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoin, join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName())))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

}
