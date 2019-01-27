package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.LessonDto;
import ru.salix.ejournal.api.entity.Lesson;
import ru.salix.ejournal.api.mapper.LessonMapper;

@Component
@RequiredArgsConstructor
public class LessonDtoBuilder extends AbstractDtoBuilder<LessonDto, Lesson> {

    private final LessonMapper lessonMapper;
    private final TimetableDtoBuilder timetableDtoBuilder;

    @Override
    public LessonDto build(Lesson lesson) {
        return lessonMapper.lessonToLessonDto(lesson);
    }

    @Override
    public LessonDto buildWithRelatedObjects(Lesson lesson) {
        var lessonDto = build(lesson);
        lessonDto.setTimetable(timetableDtoBuilder.build(lesson.getTimetable()));
        return lessonDto;
    }

}
