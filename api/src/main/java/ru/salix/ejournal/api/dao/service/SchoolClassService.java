package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.SchoolClassRepository;
import ru.salix.ejournal.api.entity.SchoolClass;

import java.util.List;

@Service
public class SchoolClassService extends BaseService<SchoolClass, SchoolClassRepository> {

    public SchoolClassService(SchoolClassRepository repository) {
        super(repository);
    }

    public List<SchoolClass> findAllByTeacherId(Long id) {
        return repository.findAllByTeacherId(id);
    }

}
