package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

@Component
@RequiredArgsConstructor
public class LessonMarkDtoBuilder extends AbstractDtoBuilder<LessonMarkDto, LessonMark> {

    private final LessonMarkMapper lessonMarkMapper;

    private final HomeworkDtoBuilder homeworkDtoBuilder;
    private final LessonDtoBuilder lessonDtoBuilder;
    private final TestDtoBuilder testDtoBuilder;

    @Override
    public LessonMarkDto build(LessonMark lessonMark) {
        return lessonMarkMapper.lessonMarkToLessonMarkDto(lessonMark);
    }

    @Override
    public LessonMarkDto buildWithRelatedObjects(LessonMark lessonMark) {
        var lessonMarkDto = build(lessonMark);
        lessonMarkDto.setHomework(homeworkDtoBuilder.build(lessonMark.getHomework()));
        lessonMarkDto.setLesson(lessonDtoBuilder.build(lessonMark.getLesson()));
        lessonMarkDto.setTest(testDtoBuilder.build(lessonMark.getTest()));
        return lessonMarkDto;
    }

}
