package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonPeriodMapper;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;

@Component
public class LessonPeriodDtoBuilder extends BaseDtoBuilder<LessonPeriodDto, LessonPeriod> {

    public LessonPeriodDtoBuilder(LessonPeriodMapper mapper) {
        super(mapper);
    }

}
