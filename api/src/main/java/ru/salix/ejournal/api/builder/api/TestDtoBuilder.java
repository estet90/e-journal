package ru.salix.ejournal.api.builder.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;
import ru.salix.ejournal.api.mapper.TestMapper;

@Component
@RequiredArgsConstructor
public class TestDtoBuilder extends AbstractDtoBuilder<TestDto, Test> {

    private final TestMapper testMapper;

    @Override
    public TestDto build(Test test) {
        return testMapper.testToTestDto(test);
    }

    @Override
    public TestDto buildWithRelatedObjects(Test entity) {
        return null;
    }

}
