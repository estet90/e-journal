package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;
import ru.salix.ejournal.api.mapper.LessonMapper;

@Component
@RequiredArgsConstructor
public class LessonDtoBuilder extends AbstractDtoBuilder<LessonDto, Lesson> {

    private final LessonMapper lessonMapper;
    private final TimetableDtoBuilder timetableDtoBuilder;

    @Override
    public LessonDto build(Lesson lesson) {
        return lessonMapper.toDto(lesson);
    }

    @Override
    public LessonDto buildWithRelatedObjects(Lesson lesson) {
        var lessonDto = build(lesson);
        lessonDto.setTimetable(timetableDtoBuilder.build(lesson.getTimetable()));
        return lessonDto;
    }

}
