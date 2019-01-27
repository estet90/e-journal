package ru.salix.ejournal.api.builder.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.LessonMarkDto;
import ru.salix.ejournal.api.entity.LessonMark;
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
