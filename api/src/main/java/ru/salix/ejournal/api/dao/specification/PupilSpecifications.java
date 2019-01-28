package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.PupilFilterDto;
import ru.salix.ejournal.api.model.dao.Pupil;
import ru.salix.ejournal.api.model.dao.Pupil_;
import ru.salix.ejournal.api.model.dao.SchoolClass_;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class PupilSpecifications {

    public Specification<Pupil> filterSpecification(PupilFilterDto filter) {
        return (Specification<Pupil>) (root, query, builder) -> {
            var classJoinOptional = ofNullable(filter.getClassName()).map(value -> root.join(Pupil_.schoolClass));
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Pupil_.id), id)),
                    predicate(filter.getName(), name -> builder.equal(root.get(Pupil_.name), name)),
                    predicate(filter.getSurname(), surname -> builder.equal(root.get(Pupil_.surname), surname)),
                    predicate(filter.getPatronymic(), patronymic -> builder.equal(root.get(Pupil_.patronymic), patronymic)),
                    predicate(filter.getDescription(), description -> builder.equal(root.get(Pupil_.description), description)),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter), liter(filter.getClassName()))),
                    predicate(classJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number), number(filter.getClassName())))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

}
