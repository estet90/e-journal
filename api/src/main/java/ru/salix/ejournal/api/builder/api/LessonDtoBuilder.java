package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMapper;
import ru.salix.ejournal.api.model.api.LessonDto;
import ru.salix.ejournal.api.model.dao.Lesson;

@Component
public class LessonDtoBuilder extends BaseDtoBuilder<LessonDto, Lesson> {

    protected LessonDtoBuilder(LessonMapper mapper) {
        super(mapper);
    }

}
