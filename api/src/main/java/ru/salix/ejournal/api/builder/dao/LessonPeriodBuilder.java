package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.LessonPeriodDto;
import ru.salix.ejournal.api.entity.LessonPeriod;
import ru.salix.ejournal.api.mapper.LessonPeriodMapper;

@Component
@RequiredArgsConstructor
public class LessonPeriodBuilder extends AbstractDaoBuilder<LessonPeriod, LessonPeriodDto> {

    private final LessonPeriodMapper lessonPeriodMapper;

    @Override
    public LessonPeriod build(LessonPeriodDto lessonPeriodDto) {
        return lessonPeriodMapper.lessonPeriodDtoToLessonPeriod(lessonPeriodDto);
    }

}
