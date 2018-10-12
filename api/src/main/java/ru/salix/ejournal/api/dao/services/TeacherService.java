package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Teacher;
import ru.salix.ejournal.api.dao.repositories.TeacherRepository;

@Service
public class TeacherService extends BaseService<Teacher, TeacherRepository> {

    public TeacherService(TeacherRepository repository) {
        super(repository);
    }

}
