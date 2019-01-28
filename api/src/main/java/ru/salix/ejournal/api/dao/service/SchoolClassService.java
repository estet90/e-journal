package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.SchoolClassRepository;
import ru.salix.ejournal.api.dao.specification.SchoolClassSpecification;
import ru.salix.ejournal.api.model.api.filter.SchoolClassFilterDto;
import ru.salix.ejournal.api.model.dao.SchoolClass;

import java.util.List;

@Service
public class SchoolClassService extends BaseService<SchoolClass, SchoolClassRepository> {

    private final SchoolClassSpecification schoolClassSpecification;

    public SchoolClassService(SchoolClassRepository repository, SchoolClassSpecification schoolClassSpecification) {
        super(repository);
        this.schoolClassSpecification = schoolClassSpecification;
    }

    public List<SchoolClass> findAllByTeacherId(Long id) {
        return repository.findAllByTeacherId(id);
    }

    public List<SchoolClass> filter(SchoolClassFilterDto filter) {
        return this.filter(schoolClassSpecification.filterSpecification(filter));
    }

}
