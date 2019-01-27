package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.LessonMarkDto;
import ru.salix.ejournal.api.entity.LessonMark;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;

@Component
@RequiredArgsConstructor
public class LessonMarkBuilder extends AbstractDaoBuilder<LessonMark, LessonMarkDto> {

    private final LessonMarkMapper lessonMarkMapper;

    @Override
    public LessonMark build(LessonMarkDto lessonMarkDto) {
        return lessonMarkMapper.lessonMarkDtoToLessonMark(lessonMarkDto);
    }

}
