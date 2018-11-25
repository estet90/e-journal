package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.controllers.dto.TeacherFilterDto;
import ru.salix.ejournal.api.dao.repositories.TeacherRepository;
import ru.salix.ejournal.api.entities.Teacher;

import java.util.List;

import static ru.salix.ejournal.api.dao.specifications.TeacherSpecifications.filterSpecification;

@Service
public class TeacherService extends BaseService<Teacher, TeacherRepository> {

    public TeacherService(TeacherRepository repository) {
        super(repository);
    }

    public List<Teacher> filter(TeacherFilterDto filter) {
        return repository.findAll(filterSpecification(filter));
    }

}
