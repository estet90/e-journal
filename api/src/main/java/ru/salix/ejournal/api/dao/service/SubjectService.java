package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controller.dto.SubjectFilterDto;
import ru.salix.ejournal.api.dao.repository.SubjectRepository;
import ru.salix.ejournal.api.entity.Subject;
import ru.salix.ejournal.api.entity.Teacher;

import java.util.List;

import static ru.salix.ejournal.api.dao.specification.SubjectSpecifications.filterSpecification;
import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

@Service
public class SubjectService extends BaseService<Subject, SubjectRepository> {

    public SubjectService(SubjectRepository repository) {
        super(repository);
    }

    public List<Subject> findAllByTeacherId(Long id) {
        var teacher = new Teacher();
        teacher.setId(id);
        return execute(() -> repository.findAllByTeachersIs(teacher), DB_EXCEPTION);
    }

    public List<Subject> filter(SubjectFilterDto filter) {
        return execute(() -> repository.findAll(filterSpecification(filter)), DB_EXCEPTION);
    }

}
