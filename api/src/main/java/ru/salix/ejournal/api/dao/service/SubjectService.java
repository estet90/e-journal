package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.api.filter.SubjectFilterDto;
import ru.salix.ejournal.api.dao.repository.SubjectRepository;
import ru.salix.ejournal.api.dao.specification.SubjectSpecifications;
import ru.salix.ejournal.api.model.dao.Subject;
import ru.salix.ejournal.api.model.dao.Teacher;

import java.util.List;

import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

@Service
public class SubjectService extends BaseService<Subject, SubjectRepository> {

    private final SubjectSpecifications subjectSpecifications;

    public SubjectService(SubjectRepository repository, SubjectSpecifications subjectSpecifications) {
        super(repository);
        this.subjectSpecifications = subjectSpecifications;
    }

    public List<Subject> findAllByTeacherId(Long id) {
        var teacher = new Teacher();
        teacher.setId(id);
        return execute(() -> repository.findAllByTeachersIs(teacher), DB_EXCEPTION);
    }

    public List<Subject> filter(SubjectFilterDto filter) {
        return filter(subjectSpecifications.filterSpecification(filter));
    }

}
