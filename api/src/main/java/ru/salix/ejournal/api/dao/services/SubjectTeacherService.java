package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.SubjectTeacher;
import ru.salix.ejournal.api.dao.repositories.SubjectTeacherRepository;

@Service
public class SubjectTeacherService extends BaseService<SubjectTeacher, SubjectTeacherRepository> {

    public SubjectTeacherService(SubjectTeacherRepository repository) {
        super(repository);
    }

}
