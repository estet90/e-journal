package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.SchoolClass;
import ru.salix.ejournal.api.entities.Teacher;
import ru.salix.ejournal.api.dao.repositories.SchoolClassRepository;

import java.util.List;

@Service
public class SchoolClassService extends BaseService<SchoolClass, SchoolClassRepository> {

    public SchoolClassService(SchoolClassRepository repository) {
        super(repository);
    }

    public List<SchoolClass> findAllByTeacher(Teacher teacher) {
        return repository.findAllByTeacher(teacher);
    }

}
