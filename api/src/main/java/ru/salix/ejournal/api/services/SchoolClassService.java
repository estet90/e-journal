package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.SchoolClass;
import ru.salix.ejournal.api.repositories.SchoolClassRepository;

@Service
public class SchoolClassService extends BaseService<SchoolClass, SchoolClassRepository> {

    public SchoolClassService(SchoolClassRepository repository) {
        super(repository);
    }

}
