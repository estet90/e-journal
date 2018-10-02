package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.Timetable;
import ru.salix.ejournal.api.repositories.TimetableRepository;

@Service
public class TimetableService extends BaseService<Timetable, TimetableRepository> {

    public TimetableService(TimetableRepository repository) {
        super(repository);
    }

}
