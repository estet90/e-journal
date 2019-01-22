package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.ExamFilterDto;
import ru.salix.ejournal.api.entity.*;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class ExamSpecifications {

    public Specification<Exam> filterSpecification(ExamFilterDto filter) {
        return (Specification<Exam>) (root, query, builder) -> {
            var classJoinOptional = ofNullable(filter.getClassName()).map(value -> root.join(Exam_.schoolClass));
            var subjectJoinOptional = ofNullable(filter.getSubject()).map(value -> root.join(Exam_.subject));
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Exam_.id), id)),
                    predicate(filter.getDatetimeFrom(), datetime -> builder.greaterThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeFrom())),
                    predicate(filter.getDatetimeTo(), datetime -> builder.lessThanOrEqualTo(root.get(Exam_.datetime), filter.getDatetimeTo())),
                    predicate(subjectJoinOptional.orElse(null), join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName())))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

}
