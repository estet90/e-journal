package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.model.dao.LessonPeriod;
import ru.salix.ejournal.api.dao.repository.LessonPeriodRepository;

@Service
public class LessonPeriodService extends BaseService<LessonPeriod, LessonPeriodRepository> {

    public LessonPeriodService(LessonPeriodRepository repository) {
        super(repository);
    }

}
