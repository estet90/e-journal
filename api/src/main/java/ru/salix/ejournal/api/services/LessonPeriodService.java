package ru.salix.ejournal.api.services;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.entities.LessonPeriod;
import ru.salix.ejournal.api.repositories.LessonPeriodRepository;

@Service
public class LessonPeriodService extends BaseService<LessonPeriod, LessonPeriodRepository> {

    public LessonPeriodService(LessonPeriodRepository repository) {
        super(repository);
    }

}
