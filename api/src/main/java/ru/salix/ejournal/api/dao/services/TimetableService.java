package ru.salix.ejournal.api.dao.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Timetable;
import ru.salix.ejournal.api.dao.repositories.TimetableRepository;

@Service
public class TimetableService extends BaseService<Timetable, TimetableRepository> {

    public TimetableService(TimetableRepository repository) {
        super(repository);
    }

}
