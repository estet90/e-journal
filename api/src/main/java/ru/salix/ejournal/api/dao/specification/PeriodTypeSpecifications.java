package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.PeriodTypeFilterDto;
import ru.salix.ejournal.api.model.dao.PeriodType;
import ru.salix.ejournal.api.model.dao.PeriodType_;

import static ru.salix.ejournal.api.helper.SpecificationHelper.predicate;
import static ru.salix.ejournal.api.helper.SpecificationHelper.where;

@Component
public class PeriodTypeSpecifications {

    public Specification<PeriodType> filterSpecification(PeriodTypeFilterDto filter) {
        return (root, query, builder) -> where(
                query,
                builder,
                predicate(filter.getId(), id -> builder.equal(root.get(PeriodType_.id), id)),
                predicate(filter.getName(), name -> builder.equal(root.get(PeriodType_.name), name))
        );
    }

}
