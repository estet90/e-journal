package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.LessonPeriodDto;
import ru.salix.ejournal.api.model.dao.LessonPeriod;
import ru.salix.ejournal.api.mapper.LessonPeriodMapper;

@Component
@RequiredArgsConstructor
public class LessonPeriodDtoBuilder extends AbstractDtoBuilder<LessonPeriodDto, LessonPeriod> {

    private final LessonPeriodMapper lessonPeriodMapper;

    @Override
    public LessonPeriodDto build(LessonPeriod lessonPeriod) {
        return lessonPeriodMapper.toDto(lessonPeriod);
    }

    @Override
    public LessonPeriodDto buildWithRelatedObjects(LessonPeriod lessonPeriod) {
        return build(lessonPeriod);
    }

}
