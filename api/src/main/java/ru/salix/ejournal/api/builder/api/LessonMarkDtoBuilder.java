package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;

@Component
@RequiredArgsConstructor
public class LessonMarkDtoBuilder extends AbstractDtoBuilder<LessonMarkDto, LessonMark> {

    private final LessonMarkMapper lessonMarkMapper;

    @Override
    public LessonMarkDto build(LessonMark lessonMark) {
        return lessonMarkMapper.lessonMarkToLessonMarkDto(lessonMark);
    }

    @Override
    public LessonMarkDto buildWithRelatedObjects(LessonMark lessonMark) {
        var lessonMArkDto = build(lessonMark);

        return null;
    }

}
