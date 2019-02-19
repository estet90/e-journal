package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonPeriodMapper;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;

@Component
public class LessonPeriodBuilder extends BaseDaoBuilder<LessonPeriod, LessonPeriodDto> {

    public LessonPeriodBuilder(LessonPeriodMapper mapper) {
        super(mapper);
    }

}
