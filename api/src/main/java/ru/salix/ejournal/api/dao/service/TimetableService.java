package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entity.Timetable;
import ru.salix.ejournal.api.dao.repository.TimetableRepository;

@Service
public class TimetableService extends BaseService<Timetable, TimetableRepository> {

    public TimetableService(TimetableRepository repository) {
        super(repository);
    }

}
