package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TestMapper;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Component
@RequiredArgsConstructor
public class TestBuilder extends AbstractDaoBuilder<Test, TestDto> {

    private final TestMapper testMapper;

    private final LessonBuilder lessonBuilder;

    @Override
    public Test build(TestDto testDto) {
        return testMapper.fromDto(testDto);
    }

    @Override
    public Test buildWithRelatedObjects(TestDto testDto) {
        var test = build(testDto);
        test.setLesson(lessonBuilder.build(testDto.getLesson()));
        return test;
    }

}
