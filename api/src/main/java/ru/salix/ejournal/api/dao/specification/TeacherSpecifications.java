package ru.salix.ejournal.api.dao.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.filter.TeacherFilterDto;
import ru.salix.ejournal.api.model.dao.*;

import static java.util.Optional.ofNullable;
import static ru.salix.ejournal.api.helper.SpecificationHelper.*;

@Component
public class TeacherSpecifications {

    public Specification<Teacher> filterSpecification(TeacherFilterDto filter) {
        return (root, query, builder) -> {
            var subjectJoinOptional = ofNullable(filter.getSubject()).map(value -> root.join(Teacher_.subjects));
            var ownClassJoinOptional = ofNullable(filter.getOwnClassName()).map(value -> root.join(Teacher_.classes));
            var relatedClassJoinOptional = ofNullable(filter.getRelatedClassName())
                    .map(value -> root.join(Teacher_.timetables).join(Timetable_.schoolClass));
            var conditions = expression(
                    builder,
                    predicate(filter.getId(), id -> builder.equal(root.get(Teacher_.id), id)),
                    predicate(filter.getName(), name -> builder.equal(root.get(Teacher_.name), name)),
                    predicate(filter.getSurname(), surname -> builder.equal(root.get(Teacher_.surname), surname)),
                    predicate(filter.getPatronymic(), patronymic -> builder.equal(root.get(Teacher_.patronymic), patronymic)),
                    predicate(filter.getDescription(), description -> builder.equal(root.get(Teacher_.description), description)),
                    predicate(subjectJoinOptional.orElse(null), join -> builder.equal(join.get(Subject_.name), filter.getSubject())),
                    predicate(ownClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number),
                            number(filter.getOwnClassName()))),
                    predicate(ownClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter),
                            liter(filter.getOwnClassName()))),
                    predicate(relatedClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.number),
                            number(filter.getRelatedClassName()))),
                    predicate(relatedClassJoinOptional.orElse(null), join -> builder.equal(join.get(SchoolClass_.liter),
                            liter(filter.getRelatedClassName())))
            );
            return query.where(conditions).getGroupRestriction();
        };
    }

}
