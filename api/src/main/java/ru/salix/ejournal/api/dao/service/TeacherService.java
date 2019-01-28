package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.api.filter.TeacherFilterDto;
import ru.salix.ejournal.api.dao.repository.TeacherRepository;
import ru.salix.ejournal.api.dao.specification.TeacherSpecifications;
import ru.salix.ejournal.api.model.dao.Teacher;

import java.util.List;

@Service
public class TeacherService extends BaseService<Teacher, TeacherRepository> {

    private final TeacherSpecifications teacherSpecifications;

    public TeacherService(TeacherRepository repository, TeacherSpecifications teacherSpecifications) {
        super(repository);
        this.teacherSpecifications = teacherSpecifications;
    }

    public List<Teacher> filter(TeacherFilterDto filter) {
        return filter(teacherSpecifications.filterSpecification(filter));
    }

}
