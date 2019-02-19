package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

@Component
public class LessonMarkDtoBuilder extends BaseDtoBuilder<LessonMarkDto, LessonMark> {

    public LessonMarkDtoBuilder(LessonMarkMapper mapper) {
        super(mapper);
    }

}
