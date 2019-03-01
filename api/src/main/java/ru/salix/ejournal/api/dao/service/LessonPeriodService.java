package ru.salix.ejournal.api.dao.service;

import org.springframework.stereotype.Service;
import ru.salix.ejournal.api.dao.repository.LessonPeriodRepository;
import ru.salix.ejournal.api.dao.specification.LessonPeriodSpecifications;
import ru.salix.ejournal.api.model.api.filter.LessonPeriodFilterDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;

import java.util.List;

@Service
public class LessonPeriodService extends BaseService<LessonPeriod, LessonPeriodRepository> {

    private final LessonPeriodSpecifications lessonPeriodSpecifications;

    public LessonPeriodService(LessonPeriodRepository repository, LessonPeriodSpecifications lessonPeriodSpecifications) {
        super(repository);
        this.lessonPeriodSpecifications = lessonPeriodSpecifications;
    }

    public List<LessonPeriod> filter(LessonPeriodFilterDto filter) {
        return filter(lessonPeriodSpecifications.filterSpecification(filter));
    }

}
