package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

@Component
public class LessonMarkBuilder extends BaseDaoBuilder<LessonMark, LessonMarkDto> {

    public LessonMarkBuilder(LessonMarkMapper mapper) {
        super(mapper);
    }

}
