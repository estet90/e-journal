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

    @Override
    public Lesson build(LessonDto lessonDto) {
        return lessonMapper.lessonDtoToLesson(lessonDto);
    }

}
