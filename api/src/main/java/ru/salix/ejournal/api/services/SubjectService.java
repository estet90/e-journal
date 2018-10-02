package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Subject;
import ru.salix.ejournal.api.repositories.SubjectRepository;

@Service
public class SubjectService extends BaseService<Subject, SubjectRepository> {

    public SubjectService(SubjectRepository repository) {
        super(repository);
    }

}
