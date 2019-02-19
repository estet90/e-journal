package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;
import ru.salix.ejournal.api.mapper.LessonMapper;

@Component
@RequiredArgsConstructor
public class LessonBuilder extends AbstractDaoBuilder<Lesson, LessonDto> {

    private final LessonMapper lessonMapper;

    private final TimetableBuilder timetableBuilder;

    @Override
    public Lesson build(LessonDto lessonDto) {
        return lessonMapper.fromDto(lessonDto);
    }

    @Override
    public Lesson buildWithRelatedObjects(LessonDto lessonDto) {
        var lesson = build(lessonDto);
        lesson.setTimetable(timetableBuilder.build(lessonDto.getTimetable()));
        return lesson;
    }

}
