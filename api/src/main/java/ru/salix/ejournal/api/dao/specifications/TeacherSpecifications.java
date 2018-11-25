package ru.salix.ejournal.api.dao.specifications;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controllers.dto.TeacherFilterDto;
import ru.salix.ejournal.api.entities.Subject;
import ru.salix.ejournal.api.entities.Teacher;
import ru.salix.ejournal.api.entities.Teacher_;

import javax.persistence.criteria.Predicate;

@Component
@RequiredArgsConstructor
public class TeacherSpecifications {

    public static Specification<Teacher> filterSpecification(TeacherFilterDto filter) {
        return (Specification<Teacher>) (root, query, criteriaBuilder) -> {
            Predicate idPredicate = criteriaBuilder.equal(root.get(Teacher_.id), filter.getId());
            Predicate namePredicate = criteriaBuilder.equal(root.get(Teacher_.name), filter.getName());
            Predicate surnamePredicate = criteriaBuilder.equal(root.get(Teacher_.surname), filter.getSurname());
            Predicate descriptionPredicate = criteriaBuilder.equal(root.get(Teacher_.description), filter.getDescription());
            Predicate subjectPredicate = criteriaBuilder.equal(root.get(Teacher_.subjects), filter.getSubject());
            Predicate relatedClassNamePredicate = criteriaBuilder.equal(root.get(Teacher_.classes), filter.getRelatedClassName());
            root.fetch(Teacher_.subjects);
            return root.in(idPredicate, namePredicate, surnamePredicate, descriptionPredicate, subjectPredicate, relatedClassNamePredicate);
        };
    }

    private static Specification<Subject> subjectsByTeacher(Long idTeacher) {
        return (Specification<Subject>) (root, query, criteriaBuilder) -> null;
    }

}
