package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.LessonMarkMapper;
import ru.salix.ejournal.api.model.api.LessonMarkDto;
import ru.salix.ejournal.api.model.dao.LessonMark;

@Component
@RequiredArgsConstructor
public class LessonMarkBuilder extends AbstractDaoBuilder<LessonMark, LessonMarkDto> {

    private final LessonMarkMapper lessonMarkMapper;

    private final HomeworkBuilder homeworkBuilder;
    private final LessonBuilder lessonBuilder;
    private final TestBuilder testBuilder;

    @Override
    public LessonMark build(LessonMarkDto lessonMarkDto) {
        return lessonMarkMapper.fromDto(lessonMarkDto);
    }

    @Override
    public LessonMark buildWithRelatedObjects(LessonMarkDto lessonMarkDto) {
        var lessonMark = build(lessonMarkDto);
        lessonMark.setHomework(homeworkBuilder.build(lessonMarkDto.getHomework()));
        lessonMark.setLesson(lessonBuilder.build(lessonMarkDto.getLesson()));
        lessonMark.setTest(testBuilder.build(lessonMarkDto.getTest()));
        return lessonMark;
    }

}
