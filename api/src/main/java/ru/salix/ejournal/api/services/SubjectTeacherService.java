package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.SubjectTeacher;
import ru.salix.ejournal.api.repositories.SubjectTeacherRepository;

@Service
public class SubjectTeacherService extends BaseService<SubjectTeacher, SubjectTeacherRepository> {

    public SubjectTeacherService(SubjectTeacherRepository repository) {
        super(repository);
    }

}
