package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controller.dto.TeacherFilterDto;
import ru.salix.ejournal.api.dao.repository.TeacherRepository;
import ru.salix.ejournal.api.entity.Teacher;

import java.util.List;

import static ru.salix.ejournal.api.dao.specification.TeacherSpecifications.filterSpecification;
import static ru.salix.ejournal.api.error.exception.InvocationExceptionCode.DB_EXCEPTION;
import static ru.salix.ejournal.api.helper.DbQueryWrapper.execute;

@Service
public class TeacherService extends BaseService<Teacher, TeacherRepository> {

    public TeacherService(TeacherRepository repository) {
        super(repository);
    }

    public List<Teacher> filter(TeacherFilterDto filter) {
        return execute(() -> repository.findAll(filterSpecification(filter)), DB_EXCEPTION);
    }

}
