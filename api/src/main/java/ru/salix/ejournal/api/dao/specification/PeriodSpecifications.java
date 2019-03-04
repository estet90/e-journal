package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.PeriodFilterDto;
import ru.salix.ejournal.api.model.dao.Period;
import ru.salix.ejournal.api.model.dao.PeriodType_;
import ru.salix.ejournal.api.model.dao.Period_;

import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class PeriodSpecifications {

    public Specification<Period> filter(PeriodFilterDto filter) {
        return (root, query, builder) -> {
            var periodTypeJoin = simpleJoin(filter.getPeriodType(), periodType -> root.join(Period_.periodType));
            return where(
                    query,
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Period_.id), id)),
                    predicate(periodTypeJoin, join -> builder.equal(join.get(PeriodType_.name), filter.getPeriodType())),
                    predicate(filter.getDateStartFrom(), date -> builder.greaterThanOrEqualTo(root.get(Period_.dateStart), date)),
                    predicate(filter.getDateStartTo(), date -> builder.lessThanOrEqualTo(root.get(Period_.dateStart), date)),
                    predicate(filter.getDateEndFrom(), date -> builder.greaterThanOrEqualTo(root.get(Period_.dateEnd), date)),
                    predicate(filter.getDateEndTo(), date -> builder.lessThanOrEqualTo(root.get(Period_.dateEnd), date))
            );
        };
    }

}
