package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.LessonPeriodFilterDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;
import ru.salix.ejournal.api.model.dao.LessonPeriod_;

import static ru.salix.ejournal.api.helper.SpecificationHelper.predicate;
import static ru.salix.ejournal.api.helper.SpecificationHelper.where;

@Component
public class LessonPeriodSpecifications {

    public Specification<LessonPeriod> filterSpecification(LessonPeriodFilterDto filter) {
        return (root, query, builder) -> where(
                query,
                builder,
                predicate(filter.getId(), id -> builder.equal(root.get(LessonPeriod_.id), id)),
                predicate(filter.getShift(), shift -> builder.equal(root.get(LessonPeriod_.shift), shift)),
                predicate(filter.getNumber(), number -> builder.equal(root.get(LessonPeriod_.number), number)),
                predicate(filter.getTimeStartFrom(), time -> builder.greaterThanOrEqualTo(root.get(LessonPeriod_.timeStart), time)),
                predicate(filter.getTimeStartTo(), time -> builder.lessThanOrEqualTo(root.get(LessonPeriod_.timeStart), time)),
                predicate(filter.getTimeEndFrom(), time -> builder.greaterThanOrEqualTo(root.get(LessonPeriod_.timeEnd), time)),
                predicate(filter.getTimeEndTo(), time -> builder.lessThanOrEqualTo(root.get(LessonPeriod_.timeEnd), time))
        );
    }

}
