package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMapper;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;

@Component
public class LessonBuilder extends BaseDaoBuilder<Lesson, LessonDto> {

    public LessonBuilder(LessonMapper mapper) {
        super(mapper);
    }

}
