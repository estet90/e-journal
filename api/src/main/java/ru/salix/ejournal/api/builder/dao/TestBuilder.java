package ru.salix.ejournal.api.builder.dao;

import org.springframework.stereotype.Component;
import ru.salix.ejournal.api.mapper.TestMapper;
import ru.salix.ejournal.api.model.api.TestDto;
import ru.salix.ejournal.api.model.dao.Test;

@Component
public class TestBuilder extends BaseDaoBuilder<Test, TestDto> {

    public TestBuilder(TestMapper mapper) {
        super(mapper);
    }

}
