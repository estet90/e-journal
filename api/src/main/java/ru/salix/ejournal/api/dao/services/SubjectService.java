package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Subject;
import ru.salix.ejournal.api.entities.Teacher;
import ru.salix.ejournal.api.dao.repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectService extends BaseService<Subject, SubjectRepository> {

    public SubjectService(SubjectRepository repository) {
        super(repository);
    }

    public List<Subject> findAllByTeachersIs(Teacher teacher) {
        return repository.findAllByTeachersIs(teacher);
    }

}
