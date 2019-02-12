package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.specification.TimetableSpecification;
import ru.salix.ejournal.api.model.api.filter.TimetableFilterDto;
import ru.salix.ejournal.api.model.dao.Timetable;
import ru.salix.ejournal.api.dao.repository.TimetableRepository;

import java.util.List;

@Service
public class TimetableService extends BaseService<Timetable, TimetableRepository> {

    private final TimetableSpecification specification;

    public TimetableService(TimetableRepository repository, TimetableSpecification specification) {
        super(repository);
        this.specification = specification;
    }

    public List<Timetable> filter(TimetableFilterDto filter) {
        return filter(specification.filterSpecification(filter));
    }

}
