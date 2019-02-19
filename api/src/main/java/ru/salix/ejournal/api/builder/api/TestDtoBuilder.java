package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TestMapper;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Component
@RequiredArgsConstructor
public class TestDtoBuilder extends AbstractDtoBuilder<TestDto, Test> {

    private final TestMapper testMapper;

    private final LessonDtoBuilder lessonDtoBuilder;

    @Override
    public TestDto build(Test test) {
        return testMapper.toDto(test);
    }

    @Override
    public TestDto buildWithRelatedObjects(Test test) {
        var testDto = build(test);
        testDto.setLesson(lessonDtoBuilder.build(test.getLesson()));
        return testDto;
    }

}
