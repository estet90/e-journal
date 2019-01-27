package ru.salix.ejournal.api.builder.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.controller.dto.TestDto;
import ru.salix.ejournal.api.entity.Test;
import ru.salix.ejournal.api.mapper.TestMapper;

@Component
@RequiredArgsConstructor
public class TestBuilder extends AbstractDaoBuilder<Test, TestDto> {

    private final TestMapper testMapper;

    @Override
    public Test build(TestDto testDto) {
        return testMapper.testDtoToTest(testDto);
    }

}
