package ru.salix.ejournal.api.builder.api;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TestMapper;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Component
public class TestDtoBuilder extends BaseDtoBuilder<TestDto, Test> {

    public TestDtoBuilder(TestMapper mapper) {
        super(mapper);
    }

}
